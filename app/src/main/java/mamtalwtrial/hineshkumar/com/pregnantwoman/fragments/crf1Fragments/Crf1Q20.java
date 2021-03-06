package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf1Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF1Activity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.LoginActivity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.constants.ContantsValues;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.UltrasoundExaminationDTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.retrofit.APIService;
import mamtalwtrial.hineshkumar.com.pregnantwoman.retrofit.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Crf1Q20 extends Fragment {

    RadioButton rb_q18, rb_q19, rb_q20, rb_q21, rb_q22, rb_q23, rb_q33, rb_q34;

    ScrollView scrollView;

    EditText et_q18, et_q24, et_q25, et_q26, et_q27, et_q28, et_q29, et_q30, et_q31, et_q32, et_q36, et_q37;

    Button btn_next;

    RadioGroup rg_q18, rg_q19, rg_q20, rg_q21, rg_q22, rg_q23, rg_q33, rg_q34;

    TextView tv_q18, tv_q19, tv_q20, tv_q21, tv_q22, tv_q23;

    ProgressDialog progressDialog;
    UltrasoundExaminationDTO ultrasoundExaminationDTO;
    private static final String Tag = "getContext";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_crf1_q18, container, false);
        initializeViews(view, getContext());

       /* rg_q18.check(rg_q18.getChildAt(4).getId());*/


        rg_q20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q20 = (RadioButton) view.findViewById(rg_q20.getCheckedRadioButtonId());

            }
        });

        rg_q21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q21 = (RadioButton) view.findViewById(rg_q21.getCheckedRadioButtonId());

            }
        });

        rg_q22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q22 = (RadioButton) view.findViewById(rg_q22.getCheckedRadioButtonId());

            }
        });

        rg_q23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q23 = (RadioButton) view.findViewById(rg_q23.getCheckedRadioButtonId());

            }
        });

        rg_q33.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q33 = (RadioButton) view.findViewById(rg_q33.getCheckedRadioButtonId());

            }
        });

        rg_q34.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q34 = (RadioButton) view.findViewById(rg_q34.getCheckedRadioButtonId());

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validation()){

                    if ((Integer.parseInt(CRF1Activity.formCrf1DTO.getQ19()) == 2 || Integer.parseInt(CRF1Activity.formCrf1DTO.getQ19()) == 3) && CRF1Activity.babyNo < Integer.parseInt(CRF1Activity.formCrf1DTO.getQ19()) ){
                        CRF1Activity.babyNo++;
                        CRF1Activity.ultrasoundExaminationDTOList.add(ultrasoundExaminationDTO);
                        CRF1Activity.fragmentManager.beginTransaction().replace(R.id.crf1_frame, new Crf1Q20(), null).addToBackStack(null).commit();

                    }else {
                        CRF1Activity.formCrf1DTO.setUltrasoundExaminationDTOS(CRF1Activity.ultrasoundExaminationDTOList);
                        CRF1Activity.formCrf1DTO.setQ38(new SimpleDateFormat(ContantsValues.TIMEFORMAT).format(Calendar.getInstance().getTime())+"");
                        sendDataToServer();
                    }


                }else {

                    Toast.makeText(getContext(),"Enter Complete Details",Toast.LENGTH_LONG).show();


                }

            }
        });


        return view;
    }

    public String checkEditTextField(EditText editText) {
        String data = "";
        if (!editText.getText().toString().equalsIgnoreCase(""))
            data = editText.getText().toString();
        else
            editText.setError("Please Enter");
        return data;
    }

    public boolean validation() {

        boolean validation = true;


       /* if (getEditText(rg_q18, rb_q18, et_q18, tv_q18, "10", "", "", "").equals("")) {
            validation = false;
        } else {
            CRF1Activity.formCrf1DTO.setQ18(getEditText(rg_q18, rb_q18, et_q18, tv_q18, "10", "", "", ""));
        }

        if (isRBCheckedThree(rg_q19, rb_q19, tv_q19).equals("")) {
            validation = false;
        } else {
            CRF1Activity.formCrf1DTO.setQ19(isRBCheckedThree(rg_q19, rb_q19, tv_q19));
        }*/

        if (isRBCheckedThree(rg_q20, rb_q20, tv_q20).equals("")) {
            validation = false;
        } else {
            ultrasoundExaminationDTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));
        }

        if (isRBCheckedThree(rg_q21, rb_q21, tv_q21).equals("")) {
            validation = false;
        } else {
            ultrasoundExaminationDTO.setQ21(isRBCheckedThree(rg_q21, rb_q21, tv_q21));
        }

        if (isRBCheckedThree(rg_q22, rb_q22, tv_q22).equals("")) {
            validation = false;
        } else {
            ultrasoundExaminationDTO.setQ22(isRBCheckedThree(rg_q22, rb_q22, tv_q22));
        }

        if (isRBCheckedThree(rg_q23, rb_q23, tv_q23).equals("")) {
            validation = false;
        } else {
            ultrasoundExaminationDTO.setQ23(isRBCheckedThree(rg_q23, rb_q23, tv_q23));
        }

        if (!checkEditTextField(et_q24).equals(""))
            ultrasoundExaminationDTO.setQ24(checkEditTextField(et_q24));
        else
            validation = false;
        if (!checkEditTextField(et_q25).equals(""))
            ultrasoundExaminationDTO.setQ25(checkEditTextField(et_q25));
        else
            validation = false;
        if (!checkEditTextField(et_q26).equals(""))
            ultrasoundExaminationDTO.setQ26(checkEditTextField(et_q26));
        else
            validation = false;
        if (!checkEditTextField(et_q27).equals(""))
            ultrasoundExaminationDTO.setQ27(checkEditTextField(et_q27));
        else
            validation = false;
        if (!checkEditTextField(et_q28).equals(""))
            ultrasoundExaminationDTO.setQ28(checkEditTextField(et_q28));
        else
            validation = false;

        if (!checkEditTextField(et_q29).equals(""))
            ultrasoundExaminationDTO.setQ29(checkEditTextField(et_q29));
        else
            validation = false;

        if (!checkEditTextField(et_q30).equals(""))
            ultrasoundExaminationDTO.setQ30(checkEditTextField(et_q30));
        else
            validation = false;


        if (!checkEditTextField(et_q31).equals(""))
            ultrasoundExaminationDTO.setQ31(checkEditTextField(et_q31));
        else
            validation = false;

        if (!checkEditTextField(et_q32).equals(""))
            ultrasoundExaminationDTO.setQ32(checkEditTextField(et_q32));
        else
            validation = false;

        if (!checkEditTextField(et_q36).equals(""))
            ultrasoundExaminationDTO.setQ36(checkEditTextField(et_q36));
        else
            validation = false;

        if (!checkEditTextField(et_q37).equals(""))
            ultrasoundExaminationDTO.setQ37(checkEditTextField(et_q37));
        else
            validation = false;

        if (rg_q33.getCheckedRadioButtonId() == -1)
            validation = false;
        else
            ultrasoundExaminationDTO.setQ33(rb_q33.getText().toString());


        if (rg_q34.getCheckedRadioButtonId() == -1)
            validation = false;
        else
            ultrasoundExaminationDTO.setQ34(rb_q34.getText().toString());


        return validation;
    }


    public void initializeViews(View view, Context context) {

        //initialiling  RADIO GROUPS
        rg_q18 = (RadioGroup) view.findViewById(R.id.rg_q18);
        rg_q19 = (RadioGroup) view.findViewById(R.id.rg_q19);
        rg_q20 = (RadioGroup) view.findViewById(R.id.rg_q20);
        rg_q21 = (RadioGroup) view.findViewById(R.id.rg_q21);
        rg_q22 = (RadioGroup) view.findViewById(R.id.rg_q22);
        rg_q23 = (RadioGroup) view.findViewById(R.id.rg_q23);
        rg_q33 = (RadioGroup) view.findViewById(R.id.rg_q33);
        rg_q34 = (RadioGroup) view.findViewById(R.id.rg_q34);


        //initialiling TEXT VIEW
        tv_q18 = (TextView) view.findViewById(R.id.tv_q18);
        tv_q19 = (TextView) view.findViewById(R.id.tv_q19);
        tv_q20 = (TextView) view.findViewById(R.id.tv_q20);
        tv_q21 = (TextView) view.findViewById(R.id.tv_q21);
        tv_q22 = (TextView) view.findViewById(R.id.tv_q22);
        tv_q23 = (TextView) view.findViewById(R.id.tv_q23);

        //initialiling EDIT TEXT
        et_q18 = (EditText) view.findViewById(R.id.et_q18);
        et_q24 = (EditText) view.findViewById(R.id.et_q24);
        et_q25 = (EditText) view.findViewById(R.id.et_q25);
        et_q26 = (EditText) view.findViewById(R.id.et_q26);
        et_q27 = (EditText) view.findViewById(R.id.et_q27);
        et_q28 = (EditText) view.findViewById(R.id.et_q28);
        et_q29 = (EditText) view.findViewById(R.id.et_q29);
        et_q30 = (EditText) view.findViewById(R.id.et_q30);
        et_q31 = (EditText) view.findViewById(R.id.et_q31);
        et_q32 = (EditText) view.findViewById(R.id.et_q32);
        et_q36 = (EditText) view.findViewById(R.id.et_q36);
        et_q37 = (EditText) view.findViewById(R.id.et_q37);


        //initialiling SCROLL VIEW
        scrollView = (ScrollView) view.findViewById(R.id.scrollView);


        //initialiling BUTTON
        btn_next = (Button) view.findViewById(R.id.btn_next);


        //initialiling RELATIVE LAYOUT

        //initialiling ProgressDialog
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Wait..");
        progressDialog.setMessage("Send Form Crf-1");


        ultrasoundExaminationDTO = new UltrasoundExaminationDTO();
    }


    public String getEditText(RadioGroup rg, RadioButton rb, EditText editText, TextView tv, String id, String id2, String id3, String id4) {

        if (rg.getCheckedRadioButtonId() == -1) {
            setFocuseable(tv.getX(), tv.getY());
            tv.setError("Required");
            return "";
        } else {
            if (rb.getTag().toString().equals(id) || rb.getTag().toString().equals(id2) ||
                    rb.getTag().toString().equals(id3) || rb.getTag().toString().equals(id4)) {

                if (editText.getText().toString().equals("") || editText.getText().toString().isEmpty()) {
                    editText.setError("Enter Here");
                    setFocuseable(editText.getX(), editText.getY());
                    return "";
                } else {
                    return rb.getTag().toString() + ":" + editText.getText().toString();
                }
            } else {

                return rb.getTag().toString();
            }

        }
    }


    int x, y;
    public void setFocuseable(float x1, float y1) {

        x = (int) x1;
        y = (int) y1;

        scrollView.post(new Runnable() {
            public void run() {
                scrollView.scrollTo(x, y); // these are your x and y coordinates
            }
        });

    }

    public String isRBCheckedThree(RadioGroup rg, RadioButton rb, TextView tv) {

        if (rg.getCheckedRadioButtonId() == -1) {
            tv.setError("Required");
            setFocuseable(tv.getX(), tv.getY());
            return "";
        } else {
            return rb.getTag().toString();
        }
    }


    public void sendDataToServer(){

        APIService mAPIService = ApiUtils.getAPIService();
        progressDialog.show();
        mAPIService.sendCrf1(CRF1Activity.formCrf1DTO).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.code() == 200){
                    progressDialog.dismiss();
                   // Toast.makeText(getContext(), response.message(),Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    getActivity().finish();

                }else {
                    //Toast.makeText(getContext(), response.message(),Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    getActivity().finish();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss();
                //Toast.makeText(getContext(), t.getMessage(),Toast.LENGTH_LONG).show();
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
            }
        });

    }


}
