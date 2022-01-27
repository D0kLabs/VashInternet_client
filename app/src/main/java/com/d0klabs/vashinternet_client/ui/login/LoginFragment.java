package com.d0klabs.vashinternet_client.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.d0klabs.vashinternet_client.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    EditText uidView;
    EditText pwdView;

    private String token;
    LoggedUser loggedUser = new LoggedUser();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {

        menu.clear();
        super.onPrepareOptionsMenu(menu);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        uidView = view.findViewById(R.id.login_uid);
        pwdView = view.findViewById(R.id.login_pwd);
        Button submitView = (Button) view.findViewById(R.id.login_submit);


        submitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();


            }
        });



        Button clearTextView = (Button) view.findViewById(R.id.clear_text_submit);
        clearTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uidView.getText().clear();
                pwdView.getText().clear();
            }
        });

        return view;
    }

    public void loginUser() {
        Context context = getActivity();
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        //String url = ApiLinks.LOGIN_URL + "?uid=" + uidView.getText() + "&pwd=" + pwdView.getText();

       /* StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main);
                    //NavDirections action = FragmentLoginDirections.actionNavToHome();
                    navController.navigate(action);

                    LoggedUser.getInstance().setJwt(response);
                    LoggedUser.getInstance().setLoggedIn(true);

                    System.out.println(response);

                    System.out.println("Things went smooth");


                }, error -> {
            System.out.println(error);
            System.out.println("Something went wrong");
        });



        System.out.println(stringRequest);
        requestQueue.add(stringRequest);

        */
    }

}