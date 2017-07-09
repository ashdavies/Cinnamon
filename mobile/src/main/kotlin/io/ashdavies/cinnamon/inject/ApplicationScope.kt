package io.ashdavies.cinnamon.inject

import dagger.releasablereferences.CanReleaseReferences
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@Retention(RUNTIME)
@CanReleaseReferences
annotation class ApplicationScope
