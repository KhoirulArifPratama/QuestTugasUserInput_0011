package com.example.tugas5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tugas5.ui.theme.Tugas5Theme

@Composable
fun Tugas5Screen(
    modifier: Modifier = Modifier,
    initialNamaDepan: String = "",
    initialNamaBelakang: String = "",
    initialEmail: String = "",
    initialTglLahir: String = "",
    initialExperience: String = "",
    initialSkillAndroid: Boolean = false,
    initialSkillUiUx: Boolean = false,
    initialSkillWeb: Boolean = false,
    initialSubmitted: Boolean = false
) {
    var namaDepan by remember { mutableStateOf(initialNamaDepan) }
    var namaBelakang by remember { mutableStateOf(initialNamaBelakang) }
    var email by remember { mutableStateOf(initialEmail) }
    var tglLahir by remember { mutableStateOf(initialTglLahir) }
    var experience by remember { mutableStateOf(initialExperience) }
    var skillAndroid by remember { mutableStateOf(initialSkillAndroid) }
    var skillUiUx by remember { mutableStateOf(initialSkillUiUx) }
    var skillWeb by remember { mutableStateOf(initialSkillWeb) }
    var isSubmitted by remember { mutableStateOf(initialSubmitted) }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Header Image Background from Drawable
            Image(
                painter = painterResource(id = R.drawable.background_terbaru),
                contentDescription = stringResource(id = R.string.content_desc_background),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.header_height))
            )

            // Floating Box / Card floating on top of Scaffold content
            Card(
                shape = RoundedCornerShape(
                    topStart = dimensionResource(id = R.dimen.card_corner_radius),
                    topEnd = dimensionResource(id = R.dimen.card_corner_radius)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.card_background)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(id = R.dimen.elevation_medium)
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = dimensionResource(id = R.dimen.header_height) - dimensionResource(id = R.dimen.header_offset))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(id = R.dimen.padding_extra_large)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_medium))
                ) {
                    if (!isSubmitted) {
                        // FORM LAYOUT (Layout Pertama)
                        Text(
                            text = stringResource(id = R.string.form_title),
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.form_title_purple),
                                fontSize = dimensionResource(id = R.dimen.font_title).value.sp
                            ),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = stringResource(id = R.string.form_subtitle),
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = colorResource(id = R.color.text_subtitle_gray),
                                fontSize = dimensionResource(id = R.dimen.font_subtitle).value.sp
                            ),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_small)))

                        // Row 1: Nama Depan & Nama Belakang
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_medium))
                        ) {
                            OutlinedTextField(
                                value = namaDepan,
                                onValueChange = { namaDepan = it },
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.hint_nama_depan),
                                        color = colorResource(id = R.color.text_dark),
                                        fontSize = dimensionResource(id = R.dimen.font_field).value.sp
                                    )
                                },
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(id = R.color.border_gray),
                                    unfocusedBorderColor = colorResource(id = R.color.border_gray)
                                ),
                                singleLine = true,
                                modifier = Modifier.weight(1f)
                            )

                            OutlinedTextField(
                                value = namaBelakang,
                                onValueChange = { namaBelakang = it },
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.hint_nama_belakang),
                                        color = colorResource(id = R.color.text_dark),
                                        fontSize = dimensionResource(id = R.dimen.font_field).value.sp
                                    )
                                },
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(id = R.color.border_gray),
                                    unfocusedBorderColor = colorResource(id = R.color.border_gray)
                                ),
                                singleLine = true,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        // Row 2: Email
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            placeholder = {
                                Text(
                                    text = stringResource(id = R.string.hint_email),
                                    color = colorResource(id = R.color.text_dark),
                                    fontSize = dimensionResource(id = R.dimen.font_field).value.sp
                                )
                            },
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.border_gray),
                                unfocusedBorderColor = colorResource(id = R.color.border_gray)
                            ),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )

                        // Row 3: Tgl Lahir & Experience
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_medium))
                        ) {
                            OutlinedTextField(
                                value = tglLahir,
                                onValueChange = { tglLahir = it },
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.hint_tgl_lahir),
                                        color = colorResource(id = R.color.text_dark),
                                        fontSize = dimensionResource(id = R.dimen.font_field).value.sp
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_calendar),
                                        contentDescription = stringResource(id = R.string.content_desc_calendar),
                                        tint = colorResource(id = R.color.text_dark)
                                    )
                                },
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(id = R.color.border_gray),
                                    unfocusedBorderColor = colorResource(id = R.color.border_gray)
                                ),
                                singleLine = true,
                                modifier = Modifier.weight(1f)
                            )

                            OutlinedTextField(
                                value = experience,
                                onValueChange = { experience = it },
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.hint_experience),
                                        color = colorResource(id = R.color.text_dark),
                                        fontSize = dimensionResource(id = R.dimen.font_field).value.sp
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_dropdown),
                                        contentDescription = stringResource(id = R.string.content_desc_dropdown),
                                        tint = colorResource(id = R.color.text_dark)
                                    )
                                },
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(id = R.color.border_gray),
                                    unfocusedBorderColor = colorResource(id = R.color.border_gray)
                                ),
                                singleLine = true,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_small)))

                        Text(
                            text = stringResource(id = R.string.title_pilih_skill),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.text_dark),
                                fontSize = dimensionResource(id = R.dimen.font_label).value.sp
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        // Checkboxes Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = skillAndroid,
                                    onCheckedChange = { skillAndroid = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(id = R.color.checkbox_checked)
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_android),
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = colorResource(id = R.color.text_dark),
                                        fontSize = dimensionResource(id = R.dimen.font_subtitle).value.sp
                                    )
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = skillUiUx,
                                    onCheckedChange = { skillUiUx = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(id = R.color.checkbox_checked)
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_ui_ux),
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = colorResource(id = R.color.text_dark),
                                        fontSize = dimensionResource(id = R.dimen.font_subtitle).value.sp
                                    )
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = skillWeb,
                                    onCheckedChange = { skillWeb = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(id = R.color.checkbox_checked)
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.skill_web),
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = colorResource(id = R.color.text_dark),
                                        fontSize = dimensionResource(id = R.dimen.font_subtitle).value.sp
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_medium)))

                        // Proceed Button
                        Button(
                            onClick = { isSubmitted = true },
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.button_gray)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.button_height))
                        ) {
                            Text(
                                text = stringResource(id = R.string.btn_proceed),
                                color = colorResource(id = R.color.button_text_white),
                                fontWeight = FontWeight.Bold,
                                fontSize = dimensionResource(id = R.dimen.font_button).value.sp
                            )
                        }
                    } else {
                        // SUBMITTED RESULT LAYOUT (Layout Setelah Submit)
                        Text(
                            text = stringResource(id = R.string.success_title),
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.success_green),
                                fontSize = dimensionResource(id = R.dimen.font_title).value.sp
                            ),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_small)))

                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = colorResource(id = R.color.success_background)
                            ),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
                                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_small))
                            ) {
                                Text(
                                    text = stringResource(id = R.string.submitted_nama_label) + " " + namaDepan + " " + namaBelakang,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = colorResource(id = R.color.text_dark),
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.submitted_email_label) + " " + email,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = colorResource(id = R.color.text_dark)
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.submitted_tgl_lahir_label) + " " + tglLahir,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = colorResource(id = R.color.text_dark)
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.submitted_experience_label) + " " + experience,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = colorResource(id = R.color.text_dark)
                                    )
                                )

                                val selectedSkills = mutableListOf<String>()
                                if (skillAndroid) selectedSkills.add(stringResource(id = R.string.skill_android))
                                if (skillUiUx) selectedSkills.add(stringResource(id = R.string.skill_ui_ux))
                                if (skillWeb) selectedSkills.add(stringResource(id = R.string.skill_web))

                                Text(
                                    text = stringResource(id = R.string.submitted_skill_label) + " " + selectedSkills.joinToString(", "),
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = colorResource(id = R.color.text_dark)
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_large)))

                        Button(
                            onClick = { isSubmitted = false },
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.button_purple)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.button_height))
                        ) {
                            Text(
                                text = stringResource(id = R.string.btn_reset),
                                color = colorResource(id = R.color.button_text_white),
                                fontWeight = FontWeight.Bold,
                                fontSize = dimensionResource(id = R.dimen.font_button).value.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Layout Pertama (Awal)")
@Composable
fun Tugas5InitialScreenPreview() {
    Tugas5Theme {
        Tugas5Screen()
    }
}

@Preview(showBackground = true, name = "Layout Setelah Submit")
@Composable
fun Tugas5SubmittedScreenPreview() {
    Tugas5Theme {
        Tugas5Screen(
            initialNamaDepan = stringResource(id = R.string.sample_nama_depan),
            initialNamaBelakang = stringResource(id = R.string.sample_nama_belakang),
            initialEmail = stringResource(id = R.string.sample_email),
            initialTglLahir = stringResource(id = R.string.sample_tgl_lahir),
            initialExperience = stringResource(id = R.string.sample_experience),
            initialSkillAndroid = true,
            initialSkillUiUx = true,
            initialSubmitted = true
        )
    }
}