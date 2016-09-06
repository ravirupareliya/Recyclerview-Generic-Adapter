# Recyclerview-Generic-Adapter

Example to illustrate use of Recyclerview-Generic-Adapter using DataBinding.

[![Twitter Follow](https://img.shields.io/twitter/follow/shields_io.svg?style=social&label=Follow&maxAge=2592000)](https://twitter.com/ravi_rupareliya)

Simple generic adapter for RecyclerView to show data using DataBinding.

# Simple example

Initialize adapter :

    RecyclerAdapter adapter = new RecyclerAdapter<>(this, arraylist, <layout id>, new RecyclerCallback<ItemBindingClassName, ModelClass>() {
        @Override
        public void bindData(ItemBindingClassName binder, ModelClass model) {
            binder.setUser(model);
        }
    });
    
use it in acitivity :

   
    public class MainActivity extends AppCompatActivity {
        private ActivityMainBinding activityMainBinding;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            
            RecyclerAdapter adapter = new RecyclerAdapter<>(this, arraylist, <layout id>, new RecyclerCallback<ItemBindingClassName, ModelClass>() {
                @Override
                public void bindData(ItemBindingClassName binder, ModelClass model) {
                    binder.setUser(model);
                }
            });
            
            activityMainBinding.rv.setAdapter(adapter);
        }
    }
