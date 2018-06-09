package br.com.wcisang.alojinha.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.com.wcisang.alojinha.R;
import br.com.wcisang.alojinha.databinding.ActivityProductDetailBinding;
import br.com.wcisang.alojinha.model.Product;
import br.com.wcisang.alojinha.viewmodel.ProductDetailViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String PRODUCT = "product";
    private ProductDetailViewModel viewModel;
    private Product product;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProductDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewModel = ViewModelProviders.of(this).get(ProductDetailViewModel.class);
        product = (Product) getIntent().getSerializableExtra(PRODUCT);
        binding.setProduct(product);
        binding.content.setProduct(product);
    }
}