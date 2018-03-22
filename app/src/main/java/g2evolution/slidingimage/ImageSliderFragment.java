package g2evolution.slidingimage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import g2evolution.slidingimage.library.BaseSliderView;
import g2evolution.slidingimage.library.DescriptionAnimation;
import g2evolution.slidingimage.library.SliderLayout;
import g2evolution.slidingimage.library.TextSliderView;
import g2evolution.slidingimage.library.ViewPagerEx;


/**
 * Created by soumyaPC on 5/6/2016.
 */


//import info.androidhive.tabsswipe.R;


public class ImageSliderFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
    private SliderLayout mDemoSlider;

    HashMap<String,String> url_maps = new HashMap<String, String>();
   // private GridLayoutManager lLayout;
    ArrayList<HashMap<String, String>> arraylist;
    ArrayList<HashMap<String, String>> arraylist1;
    //JSONParser jsonParser = new JSONParser();
  //  RecyclerViewAdapter rcAdapter;

    TextView textpercent;

   // ProductitemsAdapter productitemadapter;



   // private List<Item_Object> allItems = new ArrayList<Item_Object>();
  //  private List<SearchProducts> allItems1 = new ArrayList<SearchProducts>();
   // RecyclerView rView;


    ImageView Search;

    String itemname;
    EditText SearchItem;
    String edititem;


    SliderLayout sliderLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.imageslider, container, false);





        mDemoSlider = (SliderLayout)rootView.findViewById(R.id.slider);



        sliderLayout = (SliderLayout)rootView.findViewById(R.id.slider);

        //edititem = SearchItem.getText().toString();


        getActivity().setTitle(null);
        //context = this;




        // List<ItemObject> rowListItem = getAllItemList();
        /*lLayout = new GridLayoutManager(getActivity(), 2);

        rView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);*/



        HashMap<String,String> url_maps = new HashMap<String, String>();

        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

       /* HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Honey",R.drawable.banner);
        file_maps.put("Furnishing",R.drawable.furn);
        file_maps.put("Beauty and Health",R.drawable.beautyhealth);
        file_maps.put("Dry Fruits", R.drawable.dryfruits);*/


        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(ImageSliderFragment.this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }


        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(2000);
        mDemoSlider.addOnPageChangeListener(this);



        return rootView;
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        // Toast.makeText(getActivity(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_custom_indicator:
                mDemoSlider.setCustomIndicator((PagerIndicator) rootView.findViewById(R.id.custom_indicator));
                break;
            case R.id.action_custom_child_animation:
                mDemoSlider.setCustomAnimation(new ChildAnimationExample());
                break;
            case R.id.action_restore_default:
                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                break;
            case R.id.action_github:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
                startActivity(browserIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    /*private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("-35%", R.drawable.blacksuit));
        allItems.add(new ItemObject("-50%", R.drawable.almond));
        allItems.add(new ItemObject("-10%", R.drawable.pista));
        allItems.add(new ItemObject("-15%", R.drawable.blacksuit));
        allItems.add(new ItemObject("-35%", R.drawable.almond));
        allItems.add(new ItemObject("-50%", R.drawable.bluesuit));
        allItems.add(new ItemObject("-10%", R.drawable.pista));
        allItems.add(new ItemObject("-15%", R.drawable.bluesuit));
        allItems.add(new ItemObject("-35%", R.drawable.blacksuit));
        allItems.add(new ItemObject("-50%", R.drawable.pista));
        allItems.add(new ItemObject("-10%", R.drawable.greensuit));
        allItems.add(new ItemObject("-15%", R.drawable.bluesuit));
        allItems.add(new ItemObject("-35%", R.drawable.almond));
        allItems.add(new ItemObject("-50%", R.drawable.pista));
        allItems.add(new ItemObject("-10%", R.drawable.greensuit));
        allItems.add(new ItemObject("-15%", R.drawable.bluesuit));

        return allItems;
    }
*//*
    class LoadSpinnerdata extends AsyncTask<String, String, String> {
        String responce;
        String message;
        String status;

        String img;
        String textname, textRent, textDeposit;
        // String glbarrstr_package_cost[];
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           *//* pDialog = new ProgressDialog(context);
            pDialog.setMessage("Loading Services");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
*//*
        }

        public String doInBackground(String... args) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            // Retrieve JSON Objects from the given URL address
            List<NameValuePair> userpramas = new ArrayList<NameValuePair>();

            url_maps = new HashMap<String, String>();
            JSONObject json = jsonParser.makeHttpRequest("http://ahilgroup.com/app/home.php", "POST", userpramas);


            Log.e("testing", "json result = " + json);

            Log.e("testing", "jon2222222222222");
            try {

                String arrayresponce = json.getString("sliders");
                Log.e("testing", "adapter value=" + arrayresponce);

                JSONArray responcearray = new JSONArray(arrayresponce);
                Log.e("testing", "responcearray value=" + responcearray);


                for (int i = 0; i < responcearray.length(); i++) {
                    //   HashMap<String,String> url_maps = new HashMap<String, String>();
                    JSONObject post = responcearray.getJSONObject(i);
                    /// HashMap<String, String> map = new HashMap<String, String>();
                    // map.put("setName", post.getString("name"));
                    // map.put("setPhoto", post.getString("profilepic"));

                    // url_maps.put(post.getString("name"));
                    // url_maps.put(post.getString("profilepic"));
                    // url_maps.put("setName", post.getString("name"));
                    // url_maps.put("setPhoto", post.getString("profilepic"));
                    url_maps.put(post.getString("name"), post.getString("slider_image"));
                    Log.e("testing", "image" + post.getString("slider_image"));

                  *//*  ItemObject item = new ItemObject();

                    item.setName(post.optString("name"));
                    item.setPhoto(post.optString("profilepic"));
                    Log.e("testing","all items = "+post.optString("profilepic"));
                    allItems.add(item);*//*

                    //HashMap<String,String> url_maps = new HashMap<String, String>();


                    // arraylist.add(map);
                    //url_maps.add(url_maps);
                }




            } catch (JSONException e) {
                e.printStackTrace();
            }

            return responce;

        }

        @Override
        protected void onPostExecute(String responce) {
            super.onPostExecute(responce);
            //   pDialog.dismiss();
            Log.e("testing", "result is = " + responce);
            for(String name : url_maps.keySet()){
                TextSliderView textSliderView = new TextSliderView(getActivity());
                // initialize a SliderLayout
                textSliderView
                        .description(name)
                        .image(url_maps.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(ImageSliderFragment.this);

                //add your extra information
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra",name);

                mDemoSlider.addSlider(textSliderView);
            }


*//*
            rcAdapter = new RecyclerViewAdapter(context, allItems);
            rView.setAdapter(rcAdapter);*//*


            *//* if (status.equals("Yes")){

            adapter = new TutorrecyclerAdapter(context, feedItemList);
            mRecyclerView.setAdapter(adapter);
        }else if (status.equals("No")){
            Toast.makeText(context,"no data found",Toast.LENGTH_LONG).show();

        }*//*


        }

    }
    class LoadSpinnerdat3 extends AsyncTask<String, String, String> {
        String responce;
        String message;
        String status;

        String img;
        String textname, textRent, textDeposit;
        // String glbarrstr_package_cost[];
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           *//* pDialog = new ProgressDialog(context);
            pDialog.setMessage("Loading Services");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();*//*

        }

        public String doInBackground(String... args) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            // Retrieve JSON Objects from the given URL address
            List<NameValuePair> userpramas = new ArrayList<NameValuePair>();

            url_maps = new HashMap<String, String>();
            JSONObject json = jsonParser.makeHttpRequest("http://ahilgroup.com/app/product_sort_price_wise.php", "POST", userpramas);


            Log.e("testing", "json result = " + json);

            Log.e("testing", "jon2222222222222");
            try {

                String arrayresponce = json.getString("ProductDetails");
                Log.e("testing", "adapter value=" + arrayresponce);

                JSONArray responcearray = new JSONArray(arrayresponce);
                Log.e("testing", "responcearray value=" + responcearray);


                for (int i = 0; i < responcearray.length(); i++) {
                    //   HashMap<String,String> url_maps = new HashMap<String, String>();
                    JSONObject post = responcearray.getJSONObject(i);
                    /// HashMap<String, String> map = new HashMap<String, String>();
                    // map.put("setName", post.getString("name"));
                    // map.put("setPhoto", post.getString("profilepic"));

                    // url_maps.put(post.getString("name"));
                    // url_maps.put(post.getString("profilepic"));
                    // url_maps.put("setName", post.getString("name"));
                    // url_maps.put("setPhoto", post.getString("profilepic"));
                    //  url_maps.put(post.getString("name"), post.getString("profilepic"));
                    //   Log.e("testing","image"+post.getString("profilepic"));

                    SearchProducts item = new SearchProducts();

                    item.setName(post.optString("name"));
                    item.setPhoto(post.optString("img_path"));
                    item.setPrice(post.optString("Price"));
                    item.setDiscount(post.optString("Discount"));
                    item.setId(post.optString("p_id"));
                    Log.e("testing", "all items = " + post.optString("img_path"));
                    allItems1.add(item);

                    //HashMap<String,String> url_maps = new HashMap<String, String>();


                    // arraylist.add(map);
                    //url_maps.add(url_maps);
                }




            } catch (JSONException e) {
                e.printStackTrace();
            }

            return responce;

        }

        @Override
        protected void onPostExecute(String responce) {
            super.onPostExecute(responce);
            //pDialog.dismiss();
            Log.e("testing", "result is = " + responce);
           *//* for(String name : url_maps.keySet()){
                TextSliderView textSliderView = new TextSliderView(getActivity());
                // initialize a SliderLayout
                textSliderView
                        .description(name)
                        .image(url_maps.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(ImageSliderFragment.this);

                //add your extra information
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra",name);

                mDemoSlider.addSlider(textSliderView);
            }
*//*


            rcAdapter = new RecyclerViewAdapter(getActivity(), allItems);
            rView.setAdapter(rcAdapter);


           *//*  if (status.equals("Yes")){

            adapter = new TutorrecyclerAdapter(context, feedItemList);
            mRecyclerView.setAdapter(adapter);
        }else if (status.equals("No")){
            Toast.makeText(context,"no data found",Toast.LENGTH_LONG).show();

        }*//*


        }

    }

    class LoadSpinnerdata2 extends AsyncTask<String, String, String> {
        String responce;
        String message;
        String status;

        String img;
        String textname, textRent, textDeposit;
        // String glbarrstr_package_cost[];
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Loading Services");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();

        }

        public String doInBackground(String... args) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            // Retrieve JSON Objects from the given URL address
            List<NameValuePair> userpramas = new ArrayList<NameValuePair>();
            //userpramas.add(new BasicNameValuePair("c", cid));

            JSONObject json = jsonParser.makeHttpRequest("http://ahilgroup.com/app/product_sort_price_wise.php", "POST", userpramas);


            Log.e("testing", "json result = " + json);

            Log.e("testing", "jon2222222222222");
            try {

                String arrayresponce = json.getString("ProductDetails");
                Log.e("testing", "adapter value=" + arrayresponce);

                JSONArray responcearray = new JSONArray(arrayresponce);
                Log.e("testing", "responcearray value=" + responcearray);


                for (int i = 0; i < responcearray.length(); i++) {

                    JSONObject post = responcearray.getJSONObject(i);
                    HashMap<String, String> map = new HashMap<String, String>();


                    Item_Object item = new Item_Object();

                    item.setId(post.optString("Product_id"));
                    item.setName(post.optString("name"));
                    item.setPhoto(post.optString("img_path"));
                    item.setPrice(post.optString("Price"));
                    item.setDiscount(post.optString("Discount"));


                    //itemname = post.optString("name");
                    Log.e("testing", "all items = " + post.optString("img_path"));
                    Log.e("itemnames mahi", "mahiall items = " + itemname);
                    allItems.add(item);




                    arraylist.add(map);
                }




            } catch (JSONException e) {
                e.printStackTrace();
            }

            return responce;

        }

        @Override
        protected void onPostExecute(String responce) {
            super.onPostExecute(responce);
            pDialog.dismiss();
            Log.e("testing", "result is = " + responce);

            rcAdapter = new RecyclerViewAdapter(getActivity(), allItems);
            rView.setAdapter(rcAdapter);
           *//* if (status.equals("Yes")){

                adapter = new TutorrecyclerAdapter(context, feedItemList);
                mRecyclerView.setAdapter(adapter);
            }else if (status.equals("No")){
                Toast.makeText(context,"no data found",Toast.LENGTH_LONG).show();

            }*//*


        }

    }

*/
}


