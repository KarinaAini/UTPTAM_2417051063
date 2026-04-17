package com.example.utptam_2417051063

import android.os.Bundle
import android.widget.MediaController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.runtime.*
import androidx.annotation.DrawableRes
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.utptam_2417051063.ui.theme.UTPTAM_2417051063Theme
import model.Pet
import model.PetSource
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UTPTAM_2417051063Theme {
                PetSreen()
            }
        }
    }
}


@Composable
fun PetSreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        PetSource.dummyPet.forEach { pet ->
            DetailScreen(pet = pet)
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun DetailScreen(pet: Pet){
    var isChecked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.width(400.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()){
         Row(
             modifier = Modifier.padding(16.dp),
             verticalAlignment = Alignment.Top
         ){
            Image(
                painter = painterResource (id = pet.imageRes),
                contentDescription = pet.nama,
                modifier = Modifier
                    .size(80.dp),
                contentScale = ContentScale.Crop
            )

            Spacer (modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = pet.nama,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer (modifier = Modifier.height(8.dp))

                Text(
                    text = pet.deskripsi,
                    style = MaterialTheme.typography.bodyMedium
                )
                }
                IconButton(
                    onClick = { isChecked = !isChecked }
                ) {
                    Icon(
                        imageVector = if (isChecked)
                            Icons.Filled.Check
                        else
                            Icons.Outlined.CheckCircle,
                        contentDescription = "Checklist",
                        tint = if (isChecked) Color.Green else Color.Gray
                     )
                 }
            }
        }
    }  //itu aja sih kak
}