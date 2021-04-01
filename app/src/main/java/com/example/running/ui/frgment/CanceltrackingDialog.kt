package com.example.running.ui.frgment

import android.app.Dialog
import android.net.sip.SipSession
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.running.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CanceltrackingDialog : DialogFragment() {

    private var yesListener: (() -> Unit?)? = null

    fun setYesListener(listener: () -> Unit){
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("삭제")
            .setMessage("삭제를 누르면 데이터가 사라집니다")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Yes" ){_,_ ->
                yesListener?.let {
                    yes->
                    yes()
                }
            }
            .setNegativeButton("취소"){ dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()

    }
}