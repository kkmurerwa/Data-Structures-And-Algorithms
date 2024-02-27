package codechallenges.misc

import java.io.File

fun getClassesInFile(): List<String> {
    val path = System.getProperty("user.dir")
    val fileNamePath = "$path/codechallenges/misc/FeatureFlagConstants.kt"

    val exists = File(fileNamePath).exists()

    if (!exists) {
        println("File does not exist")
        return emptyList()
    }

    val inputStream: List<String> = File(fileNamePath).readLines()
    val listOfFeatureFlagNames = mutableListOf<String>()
    inputStream.forEach {
        if (it.contains("android_enable")) {
            val className = it.split(" ").last()
            listOfFeatureFlagNames.add(className)
        }
    }

    println("List of annotated classes: $listOfFeatureFlagNames")

    return listOfFeatureFlagNames
}

fun getClassNames(): List<String> {
    val listOfClasses = listOf(
        EnableDownloadsSupport::class, EnableLanguageSelectionUi::class,
        EnableExtraTopicTabsUi::class, EnableLearnerStudyAnalytics::class,
        EnableFastLanguageSwitchingInLesson::class, EnableLoggingLearnerStudyIds::class,
        EnableEditAccountsOptionsUi::class, EnablePerformanceMetricsCollection::class,
        EnableSpotlightUi::class, EnableInteractionConfigChangeStateRetention::class,
        EnableAppAndOsDeprecation::class, EnableNpsSurvey::class, EnableOnboardingFlowV2::class,
    )

    val classNames = listOfClasses.map { it.simpleName!! }

    return classNames
}

fun main() {
    val classesInFile = getClassesInFile()
//    val classNames = getClassNames()
//
//    val classesInFileSet = classesInFile.toSet()
//    val classNamesSet = classNames.toSet()
//
//    val classesInFileNotInClassNames = classesInFileSet.minus(classNamesSet)
//
//    println("Classes in file but not in class names: $classesInFileNotInClassNames")
}