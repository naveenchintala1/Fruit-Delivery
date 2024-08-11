package com.project.fruitdelivery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutUsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFE8F5E9)) // Light green background
    ) {
        item {
            Text(
                text = "About Us",
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold),
                color = Color(0xFF388E3C), // Deep green color
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                textAlign = TextAlign.Center
            )
            Divider(
                color = Color(0xFF2E7D32),
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
        }
        item {
            Text(
                text = "Farm-Fresh & Sustainable: Handpicked for Your Delivery!",
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
                color = Color(0xFF388E3C),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        val bodyTexts = listOf(
            "At Fresh Fruit & Veg, we are passionate about supporting local producers and promoting sustainable agriculture. We have carefully curated relationships at the Glasgow Fruit Market (in which we ourselves are based) and our commitment is to source, and procure only the more delicious and seasonal produce available in the market on that day. We ensure that every item in your delivery is sourced with utmost care and attention.",
            "With roots tracing back to 1978, Fresh Fruit & Veg are no ordinary fruit company. We’ve mastered the art of bringing you the finest fruits and veggies, while constantly embracing change and keeping your experience at the heart of everything we do.",
            "Here’s the juicy scoop: We’re not content with simply being good; we strive to be exceptional. Our passion for improvement fuels us to reach new heights and deliver an unrivaled customer experience. We believe that the secret ingredient to success in any business lies in staying dynamic and responsive to your needs."
        )

        items(bodyTexts) { text ->
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                color = Color.Black,
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .padding(bottom = 16.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
        item {
            Text(
                text = "Contact Us",
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold),
                color = Color(0xFF388E3C),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                textAlign = TextAlign.Center
            )
            Divider(
                color = Color(0xFF2E7D32),
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            Text(
                text = "Get In Touch with Us",
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
                color = Color(0xFF388E3C),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "If you have questions or need to speak with us you can reach us on all of the social media channels or contact us using the details below. We are always happy to help.",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                color = Color.Black,
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Address:\n59 Main Street, Uddingston,\nNear Tee Side",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Contact Person:\nVenkata Ramana Madrasu",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                color = Color.Blue,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Email:\nramanamadrasu@gmail.com",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
                    .padding(bottom = 16.dp)
            )
        }
    }
}