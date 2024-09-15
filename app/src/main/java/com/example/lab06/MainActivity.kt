package com.example.lab06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab06.ui.theme.Lab06Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                AppNavigation()
            }

        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("profile") { UserProfileScreen(navController) }
        composable("build") { BuildScreen(navController) }
        composable("menu") { MenuScreen(navController) }
        composable("favorite") { FavoriteScreen(navController) }
        composable("delete") { DeleteScreen(navController) }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu")
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search")
            }
            IconButton(onClick = {
                navController.navigate("profile")
            }) {
                Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "Profile")
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavController) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { navController.navigate("build") }) {
                    Icon(Icons.Filled.Build, contentDescription = "Build")
                }
                IconButton(onClick = { navController.navigate("menu") }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menu")
                }
                IconButton(onClick = { navController.navigate("favorite") }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                }
                IconButton(onClick = { navController.navigate("delete") }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete")
                }
            }
        }
    )
}


@Composable
fun CustomFAB(onFabClick: () -> Unit) {
    FloatingActionButton(
        onClick = onFabClick,
        content = {
            Text(fontSize = 24.sp, text = "+")
        }
    )
}

@Composable
fun MainScreen(navController: NavController) {
    var count by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = {
            CustomFAB { count++ }
        },
        content = { padding ->
            CustomContent(padding, count)
        }
    )
}

@Composable
fun CustomContent(padding: PaddingValues, count: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "My app content")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Boton presionado $count veces")
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithBackButton(navController: NavController, title: String) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        title = { Text(text = title) },
        actions = {  }
    )
}


@Composable
fun UserProfileScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarWithBackButton(navController, title = "Perfil de usuario") },
        content = { paddingValues ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(text = "Pantalla de perfil de usuario")
            }
        }
    )
}



@Composable
fun BuildScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarWithBackButton(navController, title = "Build Screen") },
        content = { paddingValues ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(text = "Pantalla Build")
            }
        }
    )
}



@Composable
fun MenuScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarWithBackButton(navController, title = "Menu Screen") },
        content = { paddingValues ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(text = " Pantalla Menu")
            }
        }
    )
}


@Composable
fun FavoriteScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarWithBackButton(navController, title = "Favorite Screen") },
        content = { paddingValues ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(text = "Pantalla Favorite")
            }
        }
    )
}



@Composable
fun DeleteScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarWithBackButton(navController, title = "Delete Screen") },
        content = { paddingValues ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(text = "Pantalla Delete")
            }
        }
    )
}
