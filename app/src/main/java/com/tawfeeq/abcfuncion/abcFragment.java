package com.tawfeeq.abcfuncion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link abcFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class abcFragment extends Fragment {

    EditText Anum,Bnum,Cnum;
    Button sol;
    TextView sol1,sol2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public abcFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment abcFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static abcFragment newInstance(String param1, String param2) {
        abcFragment fragment = new abcFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_abc, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Anum=getView().findViewById(R.id.etAnum);
        Bnum=getView().findViewById(R.id.etBnum);
        Cnum=getView().findViewById(R.id.etCnum);
        sol1=getView().findViewById(R.id.Sol1);
        sol2=getView().findViewById(R.id.Sol2);
        sol=getView().findViewById(R.id.btnCalc);
        sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check info
                String A=Anum.getText().toString();
                String B=Bnum.getText().toString();
                String C=Cnum.getText().toString();
                if(A.trim().isEmpty()||B.trim().isEmpty()||C.trim().isEmpty())
                    Toast.makeText(getActivity(), "Missing Numbers!", Toast.LENGTH_SHORT).show();

                Double a=Double.parseDouble(A);
                Double b=Double.parseDouble(B);
                Double c=Double.parseDouble(C);
                Double delta = (b*b) - 4*a*c;
                Double Solution1= -b+Math.sqrt(delta)/ 2*a;
                Double Solution2= -b-Math.sqrt(delta)/ 2*a;
                if(delta==0)
                {
                    Toast.makeText(getActivity(), "There is only ONE solution", Toast.LENGTH_SHORT).show();
                    sol1.setText(Solution1.toString());
                    sol2.setText("");
                }
                else if (delta>0)
                {
                    Toast.makeText(getActivity(), "There are Two solution", Toast.LENGTH_SHORT).show();
                    sol1.setText(Solution1.toString());
                    sol2.setText(Solution2.toString());
                }
                else {
                    Toast.makeText(getActivity(), "There are NO solutions", Toast.LENGTH_SHORT).show();
                    sol1.setText("");
                    sol2.setText("");
                }
                return;
            }
        });




    }
}