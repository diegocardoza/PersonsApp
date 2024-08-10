package com.diegocardoza.personroomapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.diegocardoza.personroomapp.R
import com.diegocardoza.personroomapp.presentation.navigation.Home
import com.diegocardoza.personroomapp.presentation.navigation.PersonDetail
import com.diegocardoza.personroomapp.presentation.screens.person_datail.PersonDetailScreen
import com.diegocardoza.personroomapp.presentation.screens.person_list.PersonListScreen
import com.diegocardoza.personroomapp.presentation.ui.theme.PersonROOMAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            PersonROOMAppTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                scrolledContainerColor = Color.White,
                                navigationIconContentColor = Color.White,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                actionIconContentColor = Color.White
                            ),
                            title = {
                                Text(text = getString(R.string.app_name))
                            }
                        )
                    },
                    floatingActionButton = {
                        val currentBackStackEntry by navController.currentBackStackEntryAsState()
                        currentBackStackEntry?.destination?.let { currentDestination ->
                            if (currentDestination.hasRoute<Home>()) {
                                FloatingActionButton(
                                    onClick = {
                                        navController.navigate(PersonDetail(-1))
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Add,
                                        contentDescription = "Add a person"
                                    )
                                }
                            }
                        }
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Home
                    ) {
                        composable<Home> {
                            PersonListScreen(
                                modifier = Modifier.padding(paddingValues),
                                navController = navController
                            )
                        }
                        composable<PersonDetail> {
                            PersonDetailScreen(
                                modifier = Modifier.padding(paddingValues),
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}