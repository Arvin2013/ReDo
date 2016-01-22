package com.buaa.arvin.mobilemsg.information;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SystemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SystemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SystemFragment extends Fragment {

    private LinearLayout mMainLayout;
    private TextView systemBootloader;
    private TextView systemBuildNumber;
    private TextView systemBusyBox;
    private TextView systemFingerprint;
    private TextView systemKernelVersion;
    private TextView systemOsVersion;
    private TextView systemRadio;
    private TextView systemRoot;
    private TextView systemSdkVersion;
    private TextView systemTimeZone;
    private TextView systemUptime;
    private TextView systemVirtualMachine;
    private TextView getSystemVirtualMachineHeap;

    public void onActivityCreated(Bundle paramBundle){
        super.onActivityCreated(paramBundle);
    }

}
