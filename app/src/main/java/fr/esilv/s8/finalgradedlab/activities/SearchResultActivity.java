package fr.esilv.s8.finalgradedlab.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import fr.esilv.s8.finalgradedlab.R;
import fr.esilv.s8.finalgradedlab.adapters.ItemsAdapter;
import fr.esilv.s8.finalgradedlab.interfaces.OnItemSelectedListener;
import fr.esilv.s8.finalgradedlab.model.Config;
import fr.esilv.s8.finalgradedlab.model.Item;
import fr.esilv.s8.finalgradedlab.model.Items;
import fr.esilv.s8.finalgradedlab.model.SearchResult;

public class SearchResultActivity extends AppCompatActivity implements OnItemSelectedListener {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Bundle bundle = getIntent().getExtras();
        String searchedText = bundle.getString("Search");
        if (searchedText != null) {
            getSearchResults(searchedText);
        }

        final Button submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newSearch = ((EditText) findViewById(R.id.searchText)).getText().toString();
                getSearchResults(newSearch);
            }
        });
    }

    private void getSearchResults(final String search) {

        StringRequest contractsRequest = new StringRequest("https://www.googleapis.com/youtube/v3/search?type=video&part=snippet&result&maxResults=25&q=\"" + search.replace(' ', '+') +"\"&key="+ Config.YOUTUBE_API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object
                SearchResult searchResult = new Gson().fromJson(response, SearchResult.class);
                Items items = searchResult.getItems();
                setAdapter(items);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Contracts", error.toString());
            }
        });

        Volley.newRequestQueue(this).add(contractsRequest);
    }

    private void setAdapter(Items items) {
        ItemsAdapter adapter = new ItemsAdapter(items);
        adapter.setOnItemSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnItemSelected(Item item) {
        VideoActivity.start(this, item.getId().getVideoId(),
                item.getSnippet().getTitle(),
                item.getSnippet().getDescription(),
                item.getSnippet().getChannelTitle());
    }


}
