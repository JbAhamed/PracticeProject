/*
 * Copyright 2023 Softzino Technologies
 */

package com.softzino.autoofix.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.softzino.composesample.ui.theme.AppColorLocal
import com.softzino.composesample.ui.theme.Typography
import com.softzino.composesample.ui.theme.md_theme_dark_background
import com.softzino.composesample.ui.theme.md_theme_dark_error
import com.softzino.composesample.ui.theme.md_theme_dark_errorContainer
import com.softzino.composesample.ui.theme.md_theme_dark_inverseOnSurface
import com.softzino.composesample.ui.theme.md_theme_dark_inversePrimary
import com.softzino.composesample.ui.theme.md_theme_dark_inverseSurface
import com.softzino.composesample.ui.theme.md_theme_dark_onBackground
import com.softzino.composesample.ui.theme.md_theme_dark_onError
import com.softzino.composesample.ui.theme.md_theme_dark_onErrorContainer
import com.softzino.composesample.ui.theme.md_theme_dark_onPrimary
import com.softzino.composesample.ui.theme.md_theme_dark_onPrimaryContainer
import com.softzino.composesample.ui.theme.md_theme_dark_onSecondary
import com.softzino.composesample.ui.theme.md_theme_dark_onSecondaryContainer
import com.softzino.composesample.ui.theme.md_theme_dark_onSurface
import com.softzino.composesample.ui.theme.md_theme_dark_onSurfaceVariant
import com.softzino.composesample.ui.theme.md_theme_dark_onTertiary
import com.softzino.composesample.ui.theme.md_theme_dark_onTertiaryContainer
import com.softzino.composesample.ui.theme.md_theme_dark_outline
import com.softzino.composesample.ui.theme.md_theme_dark_outlineVariant
import com.softzino.composesample.ui.theme.md_theme_dark_primary
import com.softzino.composesample.ui.theme.md_theme_dark_primaryContainer
import com.softzino.composesample.ui.theme.md_theme_dark_scrim
import com.softzino.composesample.ui.theme.md_theme_dark_secondary
import com.softzino.composesample.ui.theme.md_theme_dark_secondaryContainer
import com.softzino.composesample.ui.theme.md_theme_dark_surface
import com.softzino.composesample.ui.theme.md_theme_dark_surfaceTint
import com.softzino.composesample.ui.theme.md_theme_dark_surfaceVariant
import com.softzino.composesample.ui.theme.md_theme_dark_tertiary
import com.softzino.composesample.ui.theme.md_theme_dark_tertiaryContainer
import com.softzino.composesample.ui.theme.md_theme_light_background
import com.softzino.composesample.ui.theme.md_theme_light_error
import com.softzino.composesample.ui.theme.md_theme_light_errorContainer
import com.softzino.composesample.ui.theme.md_theme_light_inverseOnSurface
import com.softzino.composesample.ui.theme.md_theme_light_inversePrimary
import com.softzino.composesample.ui.theme.md_theme_light_inverseSurface
import com.softzino.composesample.ui.theme.md_theme_light_onBackground
import com.softzino.composesample.ui.theme.md_theme_light_onError
import com.softzino.composesample.ui.theme.md_theme_light_onErrorContainer
import com.softzino.composesample.ui.theme.md_theme_light_onPrimary
import com.softzino.composesample.ui.theme.md_theme_light_onPrimaryContainer
import com.softzino.composesample.ui.theme.md_theme_light_onSecondary
import com.softzino.composesample.ui.theme.md_theme_light_onSecondaryContainer
import com.softzino.composesample.ui.theme.md_theme_light_onSurface
import com.softzino.composesample.ui.theme.md_theme_light_onSurfaceVariant
import com.softzino.composesample.ui.theme.md_theme_light_onTertiary
import com.softzino.composesample.ui.theme.md_theme_light_onTertiaryContainer
import com.softzino.composesample.ui.theme.md_theme_light_outline
import com.softzino.composesample.ui.theme.md_theme_light_outlineVariant
import com.softzino.composesample.ui.theme.md_theme_light_primary
import com.softzino.composesample.ui.theme.md_theme_light_primaryContainer
import com.softzino.composesample.ui.theme.md_theme_light_scrim
import com.softzino.composesample.ui.theme.md_theme_light_secondary
import com.softzino.composesample.ui.theme.md_theme_light_secondaryContainer
import com.softzino.composesample.ui.theme.md_theme_light_surface
import com.softzino.composesample.ui.theme.md_theme_light_surfaceTint
import com.softzino.composesample.ui.theme.md_theme_light_surfaceVariant
import com.softzino.composesample.ui.theme.md_theme_light_tertiary
import com.softzino.composesample.ui.theme.md_theme_light_tertiaryContainer

object CustomColor {
    val englishVermillion = Color(0xFFCB444A)
    val mikadoYellow = Color(0xFFFFC107)
    val blueGreen = Color(0xFF17A2B8)
    val marigold = Color(0xFFF39D2A)
    val patriarch = Color(0xFF800080)
    val americanGreen = Color(0xFF28A745)
    val azure = Color(0xFF0096FF)
    val red = Color(0xFFFF563F)
    val lightSilver = Color(0xFFD0D5DD)
    val middleGreen = Color(0xFF53A451)
    val maize = Color(0xFFF6C244)
    val verdigris = Color(0xFF4BA0B5)
    val darkElectricBlue = Color(0xFF596980)
    val persianIndigo = Color(0xFF3C1F76)
    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF000000)
}

private val lightAppColorLocal =
    AppColorLocal(
        englishVermillion = Color(0xFFCB444A),
        mikadoYellow = Color(0xFFFFC107),
        blueGreen = Color(0xFF17A2B8),
        marigold = Color(0xFFF39D2A),
        patriarch = Color(0xFF800080),
        americanGreen = Color(0xFF28A745),
        azure = Color(0xFF0096FF),
        red = Color(0xFFFF563F),
        lightSilver = Color(0xFFD0D5DD),
        middleGreen = Color(0xFF53A451),
        maize = Color(0xFFF6C244),
        verdigris = Color(0xFF4BA0B5),
        darkElectricBlue = Color(0xFF596980),
        persianIndigo = Color(0xFF3C1F76),
        white = Color(0xFFFFFFFF),
        black = Color(0xFF000000),
    )

private val darkAppColorLocal =
    AppColorLocal(
        englishVermillion = Color(0xFFFFEB3B),
        mikadoYellow = Color(0xFFFFC107),
        blueGreen = Color(0xFF17A2B8),
        marigold = Color(0xFFF39D2A),
        patriarch = Color(0xFF800080),
        americanGreen = Color(0xFF28A745),
        azure = Color(0xFF0096FF),
        red = Color(0xFFFF563F),
        lightSilver = Color(0xFFD0D5DD),
        middleGreen = Color(0xFF53A451),
        maize = Color(0xFFF6C244),
        verdigris = Color(0xFF4BA0B5),
        darkElectricBlue = Color(0xFF596980),
        persianIndigo = Color(0xFF3C1F76),
        white = Color(0xFFFFFFFF),
        black = Color(0xFF000000),
    )

private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,

)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,

)
val LocalAppColorScheme = staticCompositionLocalOf { lightAppColorLocal }

@Composable
fun ComposeSampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    var appColorLocal: AppColorLocal = lightAppColorLocal
    val colorScheme: ColorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> {
                appColorLocal = darkAppColorLocal
                DarkColorScheme
            }

            else -> {
                appColorLocal = lightAppColorLocal
                LightColorScheme
            }
        }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
//    }

    CompositionLocalProvider(
        LocalAppColorScheme provides appColorLocal,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content,
        )
    }
}
