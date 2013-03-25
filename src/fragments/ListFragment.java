package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fragments.android.DetailActivity;
import com.fragments.android.R;

public class ListFragment extends android.support.v4.app.ListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		// создали массив телефонов
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS",
				"Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2" };
		// задаем массиву куда будем выводить и что
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {

		// получаем позицию кликнутого елемента
		String item = (String) getListAdapter().getItem(position);
		// проверяем в какой ориентации находится телефон,
		// если горизонтальная тогда вызываем фрагмент и передаем в него
		DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
		if ((fragment != null) && fragment.isInLayout()) {
			fragment.setText(item);
			// если же вертикальная то вызываем интент и передаем на него параметр кликнутого елемента
		} else {
			Intent intent = new Intent(getActivity().getApplicationContext(), DetailActivity.class);
			intent.putExtra("value", item);
			startActivity(intent);
		}
	}
}