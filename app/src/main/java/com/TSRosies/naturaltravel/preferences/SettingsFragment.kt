package com.TSRosies.naturaltravel.preferences

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.TSRosies.naturaltravel.R


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}