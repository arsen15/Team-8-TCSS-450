package edu.uw.tcss450.tcss450group82022.ui.contacts;

import static edu.uw.tcss450.tcss450group82022.ui.contacts.ContactFragmentDirections.actionNavigationContactToNavigationChats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import edu.uw.tcss450.tcss450group82022.R;
import edu.uw.tcss450.tcss450group82022.databinding.FragmentContactBinding;
import edu.uw.tcss450.tcss450group82022.databinding.FragmentContactListBinding;
import edu.uw.tcss450.tcss450group82022.model.UserInfoViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {


    private ContactViewModel mContactModel;
    private UserInfoViewModel mUserModel;
    private ContactFragmentArgs mArgs;
    private ContactListRecyclerViewAdapter contactListAdapter;
    private FragmentContactListBinding mBinding;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(getActivity());
        mUserModel = provider.get(UserInfoViewModel.class);
        mContactModel = provider.get(ContactViewModel.class);
        mArgs = ContactFragmentArgs.fromBundle(getArguments());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentContactBinding binding = FragmentContactBinding.bind(getView());

        binding.contactNameEdittext.setText(mArgs.getContact().getContactFullName());
        binding.contactEmailEdittext.setText(mArgs.getContact().getmContactEmail());
        //On button click, navigate to Third Home
        binding.contactChatButton.setOnClickListener(button ->
                Navigation.findNavController(requireView()).navigate(
                        actionNavigationContactToNavigationChats()
                        ));

    }
}
