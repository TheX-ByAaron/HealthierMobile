package com.tech.phantoms.healthier.models

data class Challenge(
    var title: String,
    var startDate: String,
    var endDate: String,
    var coach: Coach,
    var progress: Float,
    var isFinished: Boolean
)

data class ChallengeRecommendation(
    var title: String,
    var startDate: String,
    var endDate: String,
    var coach: Coach
)

data class ChallengeAnalytic(
    var title: String,
    var coach: Coach,
    var duration: String,
    var participantNumber: Int
)
