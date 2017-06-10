package com.jard.testretrofit.presenter;

import com.jard.testretrofit.pojo.Foto;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jarodrig on 01/06/2017.
 */

public interface IRecyclerViewPresenter {
    public void getFoto() throws IOException;
    public void showFotoRecyclerView();
    public ArrayList<Foto> getFotos();
}
