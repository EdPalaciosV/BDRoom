package com.example.usuario.bdroom;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogoBusqueda extends Dialog {

    Context context;
    @BindView(R.id.dialogo_et_nombre)
    EditText dialogoEtNombre;
    @BindView(R.id.dialogo_et_sexo)
    EditText dialogoEtSexo;
    @BindView(R.id.dialogo_btn_aceptar)
    Button dialogoBtnAceptar;

    ValuesDialog valuesDialog;

    public DialogoBusqueda(Context context) {
        super(context);
        this.context = context;
        valuesDialog=(ValuesDialog)context;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogo_busqueda);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getAttributes().width = LinearLayout.LayoutParams.MATCH_PARENT;
        ButterKnife.bind(this);

    }

    @OnClick(R.id.dialogo_btn_aceptar)
    public void onViewClicked() {

        valuesDialog.valuesDialog(dialogoEtNombre.getText().toString(),dialogoEtSexo.getText().toString());
    }

}
