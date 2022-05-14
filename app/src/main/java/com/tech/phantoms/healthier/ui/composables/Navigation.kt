package com.tech.phantoms.healthier.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tech.phantoms.healthier.R
import com.tech.phantoms.healthier.ui.theme.*

data class NavRoute(
    var route: String,
    var iconUnselected: Int,
    var iconSelected: Int
)

@Composable
fun TopBar(){

    Row(verticalAlignment = Alignment.CenterVertically
        ,modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)){

        Image(painter = painterResource(id = R.drawable.ic_logo_stripped)
            , contentDescription = "App logo"
            , modifier = Modifier
                .padding(start = 16.dp)
                .size(50.dp))

        Spacer(modifier = Modifier
            .height(50.dp)
            .weight(1F))

        Icon(painter = painterResource(id = R.drawable.ic_notification)
            , contentDescription = "Action Notification"
            , tint = MaterialTheme.colors.Hpink
            , modifier = Modifier
                .padding(start = 8.dp, end = 4.dp, top = 8.dp, bottom = 8.dp)
                .size(30.dp)
                .clip(MaterialTheme.shapes.MediumRound)
                .clickable { })

        Icon(painter = painterResource(id = R.drawable.ic_settings)
            , contentDescription = "Action Settings"
            , tint = MaterialTheme.colors.Hpink
            , modifier = Modifier
                .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                .size(30.dp)
                .clip(MaterialTheme.shapes.MediumRound)
                .clickable { })
    }
}


@Composable
fun BottomNavBar(navRoutes: ArrayList<NavRoute>
                 ,homeRoute: String
                 , navController: NavController){

    val isSelected = navController.currentBackStackEntryAsState()

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .height(60.dp)
            .background(color = MaterialTheme.colors.RoyalBlack, shape = MaterialTheme.shapes.MediumRound)
            .padding(vertical = 5.dp, horizontal = 1.dp)
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceEvenly) {

            navRoutes.forEachIndexed{_,route ->
                BottomNavItem(
                    iconSelected = route.iconSelected,
                    iconUnselected = route.iconUnselected,
                    isSelected = isSelected.value?.destination?.route == route.route,
                    modifier = Modifier.padding(horizontal = 4.dp)
                        .height(50.dp)
                        .weight(1F)
                        .clip(MaterialTheme.shapes.MediumRound)
                        .clickable { navController.navigateTo(route = route.route, home = homeRoute) }
                )
            }
        }
    }
}

@Composable
fun BottomNavItem(modifier: Modifier = Modifier
                  , iconSelected: Int
                  , iconUnselected: Int
                  , isSelected: Boolean){


    Column(modifier= modifier
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = if(isSelected) Arrangement.SpaceBetween else Arrangement.Center){

        Image(modifier = Modifier
            .padding(all = 8.dp)
            .size(25.dp)
            , painter = painterResource(id = if(isSelected) iconSelected else iconUnselected)
            , contentDescription = "Bottom bar item"
            , colorFilter = ColorFilter.tint(MaterialTheme.colors.Hyellow))

        AnimatedVisibility(visible = isSelected) {
            Surface(modifier = Modifier
                .height(5.dp)
                .width(35.dp)
                ,color = MaterialTheme.colors.Hyellow
                , shape = MaterialTheme.shapes.MediumRound){}
        }

    }

}

fun NavController.navigateTo(route: String, home: String){
    this.navigate(route){
        launchSingleTop = true
        popUpTo(home)
        restoreState = true
    }
}