package com.prakash.composebasics

import android.widget.Button
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun InstagramProfilePageUIClone(navController: NavController) {
    Column {
        AppBar(title = "@UchihaObitoOfLeaf", navController)
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(4.dp))
        ButtonSection()
    }
}

@Composable
fun AppBar(
    title: String,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back arrow",
            )
        }
        Text(
            text = title,
            modifier = Modifier.widthIn(50.dp, 200.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "bell icon",
            modifier = Modifier.size(21.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dot_menu),
            contentDescription = "menu",
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
fun ProfileSection(){
    Column( modifier = Modifier.fillMaxWidth() ) {
        ProfileStats()
        Spacer(modifier = Modifier.height(4.dp))
        ProfileDescription(Modifier, "(うちはオビト, Uchiha Obito) ", "A member of Konohagakure's Uchiha clan.", listOf("Madara, Nagato"), 18)
    }
}

@Composable
fun ProfileStats(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundImage(modifier = Modifier
            .width(100.dp)
            .weight(3f), image = painterResource(id = R.drawable.ic_profile_img))
        Spacer(modifier = Modifier.width(16.dp))
        StatsSection(Modifier.weight(7f))
    }
}

@Composable
fun ProfileDescription(
    modifier: Modifier = Modifier,
    displayName: String,
    description: String,
    followedBy: List<String>,
    othersCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
   Column(
       modifier = modifier
           .fillMaxWidth()
           .padding(horizontal = 20.dp)
   ) {
       Text(
           text = displayName,
           fontWeight = FontWeight.Bold,
           letterSpacing = letterSpacing,
           lineHeight = lineHeight
       )
       Spacer(modifier = modifier.height(2.dp))
       Text(
           text = description,
           letterSpacing = letterSpacing,
           lineHeight = lineHeight,
           maxLines = 4,
       )
       if(followedBy.isNotEmpty()){
           Text(
               text = buildAnnotatedString {
                   val boldStyle = SpanStyle(
                       color = Color.Black,
                       fontWeight = FontWeight.Bold
                   )
                   append("Followed by ")
                   followedBy.forEachIndexed { index, name ->
                       pushStyle(boldStyle)
                       append(name)
                       pop()
                       if(index < followedBy.size-1){
                           append(", ")
                       }
                   }
                   if(othersCount > 2){
                       append(" and ")
                       pushStyle(boldStyle)
                       append("$othersCount others")
                   }
               },
               lineHeight = lineHeight,
               letterSpacing = letterSpacing
           )
       }
   }
}

@Composable
fun RoundImage(
    modifier: Modifier,
    image: Painter
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatsSection( modifier: Modifier = Modifier ){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
       StatItem(title = "10", description = "Posts")
       StatItem(title = "100K", description = "Followers")
       StatItem(title = "99", description = "Following")
    }
}

@Composable
fun StatItem(
    title: String,
    description: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title,
            maxLines = 1,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = description,
            maxLines = 1,
        )
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
){
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ActionButton(
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height),
            title = "Following",
            icon = Icons.Default.KeyboardArrowDown
        )
        ActionButton(
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height),
            title = "Message",
        )
        ActionButton(
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height),
            title = "Email",
        )
        ActionButton(
            modifier = Modifier
                .size(height),
            title = null,
            icon = Icons.Default.KeyboardArrowDown
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    title: String? = null,
    icon: ImageVector? = null
){
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(5.dp),
                color = Color.LightGray
            )
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
       if(title != null){
           Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
       }
        if(icon != null){
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
            )
        }
    }
}