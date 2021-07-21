package com.google.homework_11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button alert3 = findViewById(R.id.alertDialog3);
        alert3.setOnClickListener(clickAlertDialog3);
    }

    private View.OnClickListener clickAlertDialog3 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            // Создаём билдер и передаём контекст приложения
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            // В билдере указываем заголовок окна. Можно указывать как ресурс, так
            // и строку
            builder.setTitle(R.string.exclamation)
                    // Указываем сообщение в окне. Также есть вариант со строковым
                    // параметром
                    .setMessage("Данные будут полностью удалены, вы действительно хотите продолжить ?")
                    // Из этого окна нельзя выйти кнопкой Back
                    .setCancelable(false)
                    // Устанавливаем отрицательную кнопку
                    .setNegativeButton(R.string.no,
                            // Ставим слушатель, будем обрабатывать нажатие
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, "Нет!", Toast.LENGTH_SHORT).show();
                                }
                            })
                    // Устанавливаем нейтральную кнопку
                    .setNeutralButton(R.string.dunno,
                            // Ставим слушатель, будем обрабатывать нажатие
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, "Вернулись обратно)", Toast.LENGTH_SHORT).show();
                                }
                            })
                    // Устанавливаем кнопку. Название кнопки также можно задавать
                    // строкой
                    .setPositiveButton(R.string.yes,
                            // Ставим слушатель, будем обрабатывать нажатие
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(Intent.ACTION_DELETE);
                                    intent.setData(Uri.parse("package:com.google.homework_11"));
                                    Toast.makeText(MainActivity.this, "Данные приложения будут удалены", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }

                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
}