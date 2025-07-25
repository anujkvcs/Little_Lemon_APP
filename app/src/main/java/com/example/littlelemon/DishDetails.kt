package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DishDetails(id: Int) {
    val dish = requireNotNull(DishRepository.getDish(id))


    Scaffold(
        topBar = {
            TopAppBar()
                    }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = dish.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.FillWidth,
            )

            Text(text = dish.name, style = MaterialTheme.typography.h1)
            Text(text = dish.description, style = MaterialTheme.typography.body1)
            Text(text = "Price: $${dish.price}", style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Quantity", style = MaterialTheme.typography.h6)
            Counter(dish = dish)
        }
    }
}

@Composable
fun Counter(dish: Dish) {
    var counter by remember { mutableStateOf(1) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextButton(
            onClick = {
                if (counter > 1) counter--
            }
        ) {
            Text(text = "-", style = MaterialTheme.typography.h5, color = Color.Black)
        }

        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        TextButton(
            onClick = { counter++ }
        ) {
            Text(text = "+", style = MaterialTheme.typography.h5, color = Color.Black)
        }
    }

    Button(
        onClick = {
            // Handle add to cart with quantity `counter`
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF4CE14)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.add_for) + " $" + String.format("%.2f", dish.price * counter)
        )
    }

}
@Preview(showBackground = true)
@Composable
fun DishDetailsPreview() {
    DishDetails(id = 1)
}