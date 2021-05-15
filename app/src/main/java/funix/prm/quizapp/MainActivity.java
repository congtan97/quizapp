package funix.prm.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Phan khai bao cac thanh phan tren layout

    //Phan nhap ten va hien thi ten tren layout
    TextView showName, showTime;
    EditText inputName;
    
    //Nut enter ten va submit ket qua
    Button submitButton, enterButton;
    
    //Cac thanh phan cac cau hoi
    RadioGroup question1RadioGroup, question5RadioGroup, question9RadioGroup;
    RadioButton question1RadioBtn, question5RadioBtn, question9RadioBtn;

    EditText question2TextInput, question4TextInput, question6TextInput, question8TextInput, question10TextInput;

    CheckBox question3CheckBox1, question3CheckBox2, question3CheckBox3, question3CheckBox4;
    CheckBox question7CheckBox1, question7CheckBox2, question7CheckBox3, question7CheckBox4;

    //Bien thoi gian dem nguoc
    CountDownTimer w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Anh xa cac phan nhap va hien thi ten, thoi gian lam bai
        inputName = (EditText) findViewById(R.id.inputName);
        showName = (TextView) findViewById(R.id.showName);
        enterButton = (Button) findViewById(R.id.enterButton);
        showTime = (TextView) findViewById(R.id.showTime);

        //Cac anh xa cac thanh phan cau hoi tren layout
        question1RadioGroup = (RadioGroup) findViewById(R.id.question1RadioGroup);
        question5RadioGroup = (RadioGroup) findViewById(R.id.question5RadioGroup);
        question9RadioGroup = (RadioGroup) findViewById(R.id.question9RadioGroup);

        question2TextInput = (EditText) findViewById(R.id.question2TextInput);
        
        question3CheckBox1 = (CheckBox) findViewById(R.id.question3CheckBox1);
        question3CheckBox2 = (CheckBox) findViewById(R.id.question3CheckBox2);
        question3CheckBox3 = (CheckBox) findViewById(R.id.question3CheckBox3);
        question3CheckBox4 = (CheckBox) findViewById(R.id.question3CheckBox4);

        question4TextInput = (EditText) findViewById(R.id.question4TextInput);

        question6TextInput = (EditText) findViewById(R.id.question6TextInput);
        
        question7CheckBox1 = (CheckBox) findViewById(R.id.question7CheckBox1);
        question7CheckBox2 = (CheckBox) findViewById(R.id.question7CheckBox2);
        question7CheckBox3 = (CheckBox) findViewById(R.id.question7CheckBox3);
        question7CheckBox4 = (CheckBox) findViewById(R.id.question7CheckBox4);

        question8TextInput = (EditText) findViewById(R.id.question8TextInput);

        question10TextInput = (EditText) findViewById(R.id.question10TextInput);

        //Phan luu cac dap an cua cac cau hoi nhap vao
        String question2Answer = "Vulcanizing";
        String question4Answer = "Gravity";
        String question6Answer1 = "Cloud";
        String question6Answer2 = "Clouds";
        String q8Answer = "Wrist";
        String question10Answer = "Smelting";

        //Anh xa nut Submit tren layout
        submitButton = (Button) findViewById(R.id.submitButton);

        //Trien khai onClick cho nut Enter nhap thong tin nguoi thi
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lay ten nguoi dung va hien thi
                String fullName = String.valueOf(inputName.getText());
                showName.setText("Your full name:" + fullName);

                //Phan dem nguoc voi thoi gian 60 giay
                w = new CountDownTimer(60000, 1000) {
                    //Hien thi thoi gian con lai
                    public void onTick(long mil) {
                        showTime.setText("Seconds remaining: " + mil/1000);
                    }
                    //Khi het thoi gian tu dong submit
                    public void onFinish() {
                        showTime.setText("Seconds remaining: 0");

                        //Bien luu giu so dap an dung
                        int numCorrect = 0;

                        //Phan kiem tra cau hoi 1
                        int q1selectedId = question1RadioGroup.getCheckedRadioButtonId();
                        if (q1selectedId != -1) {
                            question1RadioBtn = (RadioButton) findViewById(q1selectedId);
                            if (question1RadioBtn.getText().equals("DNA")) {
                                numCorrect += 1;
                            }
                        }

                        //Phan kiem tra cau 2
                        if (question2TextInput.getText().toString().equalsIgnoreCase(question2Answer)) {
                            numCorrect += 1;
                        }

                        //Phan kiem tra cau 3
                        if (question3CheckBox1.isChecked() && question3CheckBox3.isChecked() && !question3CheckBox2.isChecked() && !question3CheckBox4.isChecked()) {
                            numCorrect += 1;
                        }

                        //Phan kiem tra cau 4
                        if (question4TextInput.getText().toString().equalsIgnoreCase(question4Answer)) {
                            numCorrect += 1;
                        }

                        //Phan kiem tra cau hoi 5
                        int q5selectedId = question5RadioGroup.getCheckedRadioButtonId();
                        if (q5selectedId != -1) {
                            question5RadioBtn = (RadioButton) findViewById(q5selectedId);
                            if (question5RadioBtn.getText().equals("Pine trees")) {
                                numCorrect += 1;
                            }
                        }

                        //Phan kiem tra cau 6
                        String userAnswer = question6TextInput.getText().toString();
                        if (userAnswer.equalsIgnoreCase(question6Answer1) || userAnswer.equalsIgnoreCase(question6Answer2)) {
                            numCorrect += 1;
                        }

                        //Phan kiem tra cau 7
                        if (question7CheckBox3.isChecked() && question7CheckBox4.isChecked() && !question7CheckBox1.isChecked() && !question7CheckBox2.isChecked()) {
                            numCorrect += 1;
                        }

                        //Phan kiem tra cau 8
                        if (question8TextInput.getText().toString().equalsIgnoreCase(q8Answer)) {
                            numCorrect += 1;
                        }

                        //Phan kiem tra cau hoi 9
                        int q9selectedId = question9RadioGroup.getCheckedRadioButtonId();
                        if (q9selectedId != -1) {
                            question9RadioBtn = (RadioButton) findViewById(q9selectedId);
                            if (question9RadioBtn.getText().equals("Stalagmites")) {
                                numCorrect += 1;
                            }
                        }

                        //Phan kiem tra cau 10
                        if (question10TextInput.getText().toString().equalsIgnoreCase(question10Answer)) {
                            numCorrect += 1;
                        }

                        //Phan thong bao ket qua
                        if (numCorrect <= 9) {
                            Toast.makeText(MainActivity.this, "Try again. You scored " + numCorrect + " out of 10", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Perfect. You scored " + numCorrect + " out of 10", Toast.LENGTH_SHORT).show();
                        }
                    }
                }.start();
            }
        });

        //Trien khai onClick cho nut Submit
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Bien luu tru so dap an dung
                int numCorrect = 0;

                //Phan kiem tra cau hoi 1
                int q1selectedId = question1RadioGroup.getCheckedRadioButtonId();
                if (q1selectedId != -1) {
                    question1RadioBtn = (RadioButton) findViewById(q1selectedId);
                    if (question1RadioBtn.getText().equals("DNA")) {
                        numCorrect += 1;
                    }
                }

                //Phan kiem tra cau 2
                if (question2TextInput.getText().toString().equalsIgnoreCase(question2Answer)) {
                    numCorrect += 1;
                }

                //Phan kiem tra cau 3
                if (question3CheckBox1.isChecked() && question3CheckBox3.isChecked() && !question3CheckBox2.isChecked() && !question3CheckBox4.isChecked()) {
                    numCorrect += 1;
                }

                //Phan kiem tra cau 4
                if (question4TextInput.getText().toString().equalsIgnoreCase(question4Answer)) {
                    numCorrect += 1;
                }

                //Phan kiem tra cau hoi 5
                int q5selectedId = question5RadioGroup.getCheckedRadioButtonId();
                if (q5selectedId != -1) {
                    question5RadioBtn = (RadioButton) findViewById(q5selectedId);
                    if (question5RadioBtn.getText().equals("Pine trees")) {
                        numCorrect += 1;
                    }
                }

                //Phan kiem tra cau 6
                String userAnswer = question6TextInput.getText().toString();
                if (userAnswer.equalsIgnoreCase(question6Answer1) || userAnswer.equalsIgnoreCase(question6Answer2)) {
                    numCorrect += 1;
                }

                //Phan kiem tra cau 7
                if (question7CheckBox3.isChecked() && question7CheckBox4.isChecked() && !question7CheckBox1.isChecked() && !question7CheckBox2.isChecked()) {
                    numCorrect += 1;
                }

                //Phan kiem tra cau 8
                if (question8TextInput.getText().toString().equalsIgnoreCase(q8Answer)) {
                    numCorrect += 1;
                }

                //Phan kiem tra cau hoi 9
                int q9selectedId = question9RadioGroup.getCheckedRadioButtonId();
                if (q9selectedId != -1) {
                    question9RadioBtn = (RadioButton) findViewById(q9selectedId);
                    if (question9RadioBtn.getText().equals("Stalagmites")) {
                        numCorrect += 1;
                    }
                }

                //Phan kiem tra cau 10
                if (question10TextInput.getText().toString().equalsIgnoreCase(question10Answer)) {
                    numCorrect += 1;
                }

                //Phan thong bao ket qua
                if (numCorrect <= 9) {
                    Toast.makeText(MainActivity.this, "Try again. You scored " + numCorrect + " out of 10", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Perfect. You scored " + numCorrect + " out of 10", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    
}