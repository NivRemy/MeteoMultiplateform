package org.example.project.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.meteo.ui.theme.Typography
import com.example.meteo.ui.theme.backgroundDark
import com.example.meteo.ui.theme.backgroundLight
import com.example.meteo.ui.theme.errorContainerDark
import com.example.meteo.ui.theme.errorContainerLight
import com.example.meteo.ui.theme.errorDark
import com.example.meteo.ui.theme.errorLight
import com.example.meteo.ui.theme.inverseOnSurfaceDark
import com.example.meteo.ui.theme.inverseOnSurfaceLight
import com.example.meteo.ui.theme.inversePrimaryDark
import com.example.meteo.ui.theme.inversePrimaryLight
import com.example.meteo.ui.theme.inverseSurfaceDark
import com.example.meteo.ui.theme.inverseSurfaceLight
import com.example.meteo.ui.theme.onBackgroundDark
import com.example.meteo.ui.theme.onBackgroundLight
import com.example.meteo.ui.theme.onErrorContainerDark
import com.example.meteo.ui.theme.onErrorContainerLight
import com.example.meteo.ui.theme.onErrorDark
import com.example.meteo.ui.theme.onErrorLight
import com.example.meteo.ui.theme.onPrimaryContainerDark
import com.example.meteo.ui.theme.onPrimaryContainerLight
import com.example.meteo.ui.theme.onPrimaryDark
import com.example.meteo.ui.theme.onPrimaryLight
import com.example.meteo.ui.theme.onSecondaryContainerDark
import com.example.meteo.ui.theme.onSecondaryContainerLight
import com.example.meteo.ui.theme.onSecondaryDark
import com.example.meteo.ui.theme.onSecondaryLight
import com.example.meteo.ui.theme.onSurfaceDark
import com.example.meteo.ui.theme.onSurfaceLight
import com.example.meteo.ui.theme.onSurfaceVariantDark
import com.example.meteo.ui.theme.onSurfaceVariantLight
import com.example.meteo.ui.theme.onTertiaryContainerDark
import com.example.meteo.ui.theme.onTertiaryContainerLight
import com.example.meteo.ui.theme.onTertiaryDark
import com.example.meteo.ui.theme.onTertiaryLight
import com.example.meteo.ui.theme.outlineDark
import com.example.meteo.ui.theme.outlineLight
import com.example.meteo.ui.theme.outlineVariantDark
import com.example.meteo.ui.theme.outlineVariantLight
import com.example.meteo.ui.theme.primaryContainerDark
import com.example.meteo.ui.theme.primaryContainerLight
import com.example.meteo.ui.theme.primaryDark
import com.example.meteo.ui.theme.primaryLight
import com.example.meteo.ui.theme.scrimDark
import com.example.meteo.ui.theme.scrimLight
import com.example.meteo.ui.theme.secondaryContainerDark
import com.example.meteo.ui.theme.secondaryContainerLight
import com.example.meteo.ui.theme.secondaryDark
import com.example.meteo.ui.theme.secondaryLight
import com.example.meteo.ui.theme.surfaceBrightDark
import com.example.meteo.ui.theme.surfaceBrightLight
import com.example.meteo.ui.theme.surfaceContainerDark
import com.example.meteo.ui.theme.surfaceContainerHighDark
import com.example.meteo.ui.theme.surfaceContainerHighLight
import com.example.meteo.ui.theme.surfaceContainerHighestDark
import com.example.meteo.ui.theme.surfaceContainerHighestLight
import com.example.meteo.ui.theme.surfaceContainerLight
import com.example.meteo.ui.theme.surfaceContainerLowDark
import com.example.meteo.ui.theme.surfaceContainerLowLight
import com.example.meteo.ui.theme.surfaceContainerLowestDark
import com.example.meteo.ui.theme.surfaceContainerLowestLight
import com.example.meteo.ui.theme.surfaceDark
import com.example.meteo.ui.theme.surfaceDimDark
import com.example.meteo.ui.theme.surfaceDimLight
import com.example.meteo.ui.theme.surfaceLight
import com.example.meteo.ui.theme.surfaceVariantDark
import com.example.meteo.ui.theme.surfaceVariantLight
import com.example.meteo.ui.theme.tertiaryContainerDark
import com.example.meteo.ui.theme.tertiaryContainerLight
import com.example.meteo.ui.theme.tertiaryDark
import com.example.meteo.ui.theme.tertiaryLight

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkScheme else lightScheme,
        typography = Typography,
        content = content
    )
}