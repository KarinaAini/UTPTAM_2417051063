package model
import com.example.utptam_2417051063.R

object PetSource {
    val dummyPet = listOf(
        Pet(
            nama = "Feed Pet",
            deskripsi = "Give Healthy Food",
            imageRes = R.drawable.pet_food
        ),
        Pet(
            nama = "Walk Pet",
            deskripsi = "Morning exersice",
            imageRes = R.drawable.pet_walking
        ),
        Pet(
            nama = "Bath Pet",
            deskripsi = "Keep them clean",
            imageRes = R.drawable.pet_bath
        ),
        Pet(
            nama = "Vaccination",
            deskripsi = "CheckUp & Shot",
            imageRes = R.drawable.pet_vaccine
        ),
    )
}