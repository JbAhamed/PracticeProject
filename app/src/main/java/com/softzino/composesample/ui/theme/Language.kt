package com.softzino.composesample.ui.theme

import android.app.LocaleManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import java.util.Locale

sealed class Language {
    // common properties
    abstract val code: String

    companion object {
        // Make sure you add all the languages here
        val allowedLocales = listOf(English, Bengali)

        fun setLocale(
            context: Context,
            localeCode: String,
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                context.getSystemService(LocaleManager::class.java).applicationLocales =
                    LocaleList.forLanguageTags(localeCode)
            } else {
                saveToLocalSharedAndUpdateResources(context = context, localeTag = localeCode)
            }
        }

        internal fun getCurrentLanguage(context: Context): Language? = this.allowedLocales.find { it.code == getCurrentLocale(context) }

        private fun getCurrentLocale(context: Context): String =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                context.getSystemService(LocaleManager::class.java).applicationLocales.toLanguageTags()
            } else {
                AppCompatDelegate.getApplicationLocales().toLanguageTags()
            }

        private const val sharedPrefSelectedLocaleKey = "LocalePreference"

        private fun getLocaleSharedPreference(context: Context): SharedPreferences? =
            context.applicationContext?.getSharedPreferences(
                sharedPrefSelectedLocaleKey,
                Context.MODE_PRIVATE,
            )

        private fun setLocaleForDevicesLowerThanTiramisu(
            localeTag: String,
            context: Context,
        ) {
            val locale = Locale(localeTag)
            Locale.setDefault(locale)
            val resources = context.resources
            val configuration = resources.configuration
            configuration.setLocale(locale)
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }

        private fun saveToLocalSharedAndUpdateResources(
            context: Context,
            localeTag: String,
        ) {
            val sharedPref = getLocaleSharedPreference(context) ?: return

            with(sharedPref.edit()) {
                putString(sharedPrefSelectedLocaleKey, localeTag)
                apply()
            }
            setLocaleForDevicesLowerThanTiramisu(localeTag, context)
        }

        // This needs to be called OnStart() or OnCreation() of the Activity for Android API level 32 and below
        fun configureLocaleOnStartForDevicesLowerThanTiramisu(context: Context) {
            getCurrentLanguage(context)?.let {
                setLocaleForDevicesLowerThanTiramisu(
                    context = context,
                    localeTag =
                        getLocaleSharedPreference(context)?.getString(
                            sharedPrefSelectedLocaleKey,
                            English.code,
                        ) ?: English.code,
                )
            }
        }

        fun checkAnyLanguageSelected(context: Context) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                Language.configureLocaleOnStartForDevicesLowerThanTiramisu(context)
            }
        }
    }

    object English : Language() {
        override val code: String = "en"
    }

    object Bengali : Language() {
        override val code: String = "bn"
    }
}
