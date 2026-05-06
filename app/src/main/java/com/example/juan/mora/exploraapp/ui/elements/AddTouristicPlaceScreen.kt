package com.example.juan.mora.exploraapp.ui.elements
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun AddTouristicPlaceScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    // 🔥 Estados
    var nombre by remember { mutableStateOf("") }
    var departamento by remember { mutableStateOf("") }
    var ciudad by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    val primaryOrange = Color(0xFFE45D25)
    val lightGrayBg = Color(0xFFF8F9FE)
    val inputBg = Color(0xFFE5E5EA)

    Surface(
        modifier = modifier.fillMaxSize(),
        color = lightGrayBg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 🔙 Botón atrás
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.Start)
                    .offset(x = (-12).dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = primaryOrange
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "AddPlace",
                color = primaryOrange,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Comparte tu descubrimiento",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )

            Text(
                text = "Ayuda a otros viajeros a encontrar lugares increíbles",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column(modifier = Modifier.fillMaxWidth()) {

                AddPlaceField(
                    label = "NOMBRE DEL LUGAR",
                    value = nombre,
                    onValueChange = { nombre = it },
                    placeholder = "Ej: Cascada del Fin del Mundo",
                    leadingIcon = Icons.Default.Place,
                    inputBg = inputBg
                )

                Spacer(modifier = Modifier.height(20.dp))

                AddPlaceField(
                    label = "DEPARTAMENTO",
                    value = departamento,
                    onValueChange = { departamento = it },
                    placeholder = "Ej: Putumayo",
                    leadingIcon = Icons.Default.LocationOn,
                    inputBg = inputBg
                )

                Spacer(modifier = Modifier.height(20.dp))

                AddPlaceField(
                    label = "CIUDAD",
                    value = ciudad,
                    onValueChange = { ciudad = it },
                    placeholder = "Ej: Mocoa",
                    leadingIcon = Icons.Default.LocationOn,
                    inputBg = inputBg
                )

                Spacer(modifier = Modifier.height(20.dp))

                AddPlaceField(
                    label = "DESCRIPCIÓN",
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    placeholder = "Cuéntanos por qué este lugar es especial...",
                    leadingIcon = Icons.Default.Description,
                    inputBg = inputBg,
                    singleLine = false
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // 🔥 Botón publicar
            Button(
                onClick = {
                    println(nombre)
                    println(departamento)
                    println(ciudad)
                    println(descripcion)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(primaryOrange, Color(0xFFFF8A65))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Publicar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun AddPlaceField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: ImageVector,
    inputBg: Color,
    singleLine: Boolean = true
) {
    Column {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 6.dp)
        )

        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = singleLine,
            placeholder = { Text(placeholder) },
            leadingIcon = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = inputBg,
                unfocusedContainerColor = inputBg,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewAddTouristicPlace() {
    AddTouristicPlaceScreen(
        navController = rememberNavController()
    )
}