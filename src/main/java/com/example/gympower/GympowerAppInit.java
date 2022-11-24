package com.example.gympower;

import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.Picture;
import com.example.gympower.model.entity.enums.FlavorEnum;
import com.example.gympower.model.entity.enums.ProductCategoriesEnum;
import com.example.gympower.model.entity.enums.SpecialFeaturesEnum;
import com.example.gympower.model.entity.products.supplements.Cut;
import com.example.gympower.model.entity.products.supplements.Flavor;
import com.example.gympower.model.entity.products.supplements.SpecialFeature;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
public class GympowerAppInit implements CommandLineRunner {

    private final SupplementRepository supplementRepository;

    private final PictureRepository pictureRepository;

    private final CutRepository cutRepository;

    private final WearRepository wearRepository;
    private final FlavorRepository flavorRepository;
    private final SpecialFeatureRepository specialFeatureRepository;
    private final CategoryRepository categoryRepository;

    public GympowerAppInit(SupplementRepository supplementRepository, PictureRepository pictureRepository, CutRepository cutRepository, WearRepository wearRepository, FlavorRepository flavorRepository, SpecialFeatureRepository specialFeatureRepository, CategoryRepository categoryRepository) {
        this.supplementRepository = supplementRepository;
        this.pictureRepository = pictureRepository;
        this.cutRepository = cutRepository;
        this.wearRepository = wearRepository;
        this.flavorRepository = flavorRepository;
        this.specialFeatureRepository = specialFeatureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        supplementsInit();
    }

    private void supplementsInit() {
        Cut cut25 = new Cut()
                .setUnit("KG")
                .setQuantity(2.5)
                .setCost(BigDecimal.valueOf(41.32))
                .setPrice(BigDecimal.valueOf(129.99))
                .setProduced(100);

        Cut cut1 = new Cut()
                .setUnit("KG")
                .setQuantity(1)
                .setCost(BigDecimal.valueOf(35.86))
                .setPrice(BigDecimal.valueOf(47.89))
                .setProduced(100);

        Cut cut500 = new Cut()
                .setUnit("G")
                .setQuantity(500)
                .setCost(BigDecimal.valueOf(16.42))
                .setPrice(BigDecimal.valueOf(23.99))
                .setProduced(100);

        Cut cut5 = new Cut()
                .setUnit("KG")
                .setQuantity(5)
                .setCost(BigDecimal.valueOf(173.74))
                .setPrice(BigDecimal.valueOf(199.99))
                .setProduced(100);

        Cut cut60 = new Cut()
                .setUnit("G")
                .setQuantity(60)
                .setCost(BigDecimal.valueOf(1.58))
                .setPrice(BigDecimal.valueOf(3.39))
                .setProduced(100);

        Cut cut40 = new Cut()
                .setUnit("G")
                .setQuantity(40)
                .setCost(BigDecimal.valueOf(0.97))
                .setPrice(BigDecimal.valueOf(2.89))
                .setProduced(100);

        Cut cutBox = new Cut()
                .setQuantity(0)
                .setUnit("12 x 65")
                .setCost(BigDecimal.valueOf(15.86))
                .setPrice(BigDecimal.valueOf(21.99))
                .setProduced(100);

        cut25 = this.cutRepository.save(cut25);
        cut1 = this.cutRepository.save(cut1);
        cut500 = this.cutRepository.save(cut500);
        cut5 = this.cutRepository.save(cut5);
        cut60 = this.cutRepository.save(cut60);
        cut40 = this.cutRepository.save(cut40);
        cutBox = this.cutRepository.save(cutBox);

        Picture proteinPic = new Picture()
                .setTitle("Protein")
                .setUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fshop.4fitness.bg%2FFiles%2FImages%2FProduct%2FCache%2FLogo_400_500_whey-protein-powder---biscuits-with-cream-908-gr.jpg&imgrefurl=https%3A%2F%2Fshop.4fitness.bg%2Fproteini%2Fsurovatachen-protein%2Fwhey-protein-powder---biscuits-with-cream-908-gr%2F&tbnid=Su7B1iMftWscTM&vet=12ahUKEwi7us6P1677AhVsyLsIHe6HA4EQMygLegUIARCPAg..i&docid=ubUUp11KdVSEDM&w=400&h=400&q=whey%20protein&ved=2ahUKEwi7us6P1677AhVsyLsIHe6HA4EQMygLegUIARCPAg");
        Picture proteinPic88 = new Picture()
                .setTitle("Protein 88")
                .setUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fcontents.mediadecathlon.com%2Fp2006424%2Fk%24155df7d00ae0c34e8742f10d6fc8fdc3%2Fprotein-whey-gold-standard-22-kg-dvoen-shokolad.jpg%3Fformat%3Dauto%26quality%3D40%26f%3D452x452&imgrefurl=https%3A%2F%2Fwww.decathlon.bg%2Fp%2F998337049-165825_protein-whey-gold-standard-22-kg-dvoen-shokolad.html&tbnid=W0ZD3MMsqOdyUM&vet=12ahUKEwi7us6P1677AhVsyLsIHe6HA4EQMygAegUIARD2AQ..i&docid=cVf5Cd6KU_gELM&w=452&h=452&q=whey%20protein&ved=2ahUKEwi7us6P1677AhVsyLsIHe6HA4EQMygAegUIARD2AQ");
        Picture barPicture = new Picture()
                .setTitle("ChocoStorm bar")
                .setUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fgymbeam.bg%2Fmedia%2Fcatalog%2Fproduct%2Fcache%2Fbf5a31e851f50f3ed6850cbbf183db11%2F5%2F1%2F51_zv7t125l._ac_sl1000__1_.jpg&imgrefurl=https%3A%2F%2Fgymbeam.bg%2Fprotein-bar-bodylab24.html&tbnid=Qu_HX36_H7TluM&vet=12ahUKEwiymNb12K77AhVQk_0HHcAoB3MQMygAegUIARD3AQ..i&docid=H6rYuEiQgKQOJM&w=700&h=700&q=protein%20bar&ved=2ahUKEwiymNb12K77AhVQk_0HHcAoB3MQMygAegUIARD3AQ");
        Picture barPicture2 = new Picture()
                .setTitle("BiscuitStorm Bar")
                .setUrl("/pictures/Protein_Bar.jpeg");
        Picture barPicturePack = new Picture()
                .setTitle("BiscuitStorm Bar Pack")
                .setUrl("/pictures/Protein_Bar_Pack.jpeg");
        Picture barPictureCoffee = new Picture()
                .setTitle("CoffeeStorm Bar Pack")
                .setUrl("/pictures/Protein_Bar_Coffe.jpeg");

        proteinPic = this.pictureRepository.save(proteinPic);
        proteinPic88 = this.pictureRepository.save(proteinPic88);

        barPicture = this.pictureRepository.save(barPicture);
        barPicture2 = this.pictureRepository.save(barPicture2);
        barPicturePack = this.pictureRepository.save(barPicturePack);
        barPictureCoffee = this.pictureRepository.save(barPictureCoffee);


        Flavor flavor1 = new Flavor()
                .setFlavor(FlavorEnum.BANANA)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor2 = new Flavor()
                .setFlavor(FlavorEnum.BANANA_CREME)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut25, cut1, cut500))
                .setAvailable(true);
        Flavor flavor3 = new Flavor()
                .setFlavor(FlavorEnum.BISCUITS_WITH_CREAM)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor4 = new Flavor()
                .setFlavor(FlavorEnum.CARAMEL_TOFFEE_FUDGE)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);
        Flavor flavor5 = new Flavor()
                .setFlavor(FlavorEnum.CHOCOLATE)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor6 = new Flavor()
                .setFlavor(FlavorEnum.CHOCOLATE_PEANUT_BUTTER)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);
        Flavor flavor7 = new Flavor()
                .setFlavor(FlavorEnum.COOKIES_CREAM)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor8 = new Flavor()
                .setFlavor(FlavorEnum.DELICIOUS_STRAWBERRY)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor9 = new Flavor()
                .setFlavor(FlavorEnum.DONT_KNOW)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut25, cut1))
                .setAvailable(true);
        Flavor flavor10 = new Flavor()
                .setFlavor(FlavorEnum.DOUBLE_RICH_CHOCOLATE)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);
        Flavor flavor11 = new Flavor()
                .setFlavor(FlavorEnum.VANILLA_ICE_CREAM)
                .setPictures(Set.of(proteinPic))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);

        Flavor flavor12 = new Flavor()
                .setFlavor(FlavorEnum.COOKIES_CREAM)
                .setPictures(Set.of(proteinPic88))
                .setCuts(Set.of(cut25, cut1, cut500))
                .setAvailable(true);
        Flavor flavor13 = new Flavor()
                .setFlavor(FlavorEnum.CARAMEL_TOFFEE_FUDGE)
                .setPictures(Set.of(proteinPic88))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);
        Flavor flavor14 = new Flavor()
                .setFlavor(FlavorEnum.DOUBLE_RICH_CHOCOLATE)
                .setPictures(Set.of(proteinPic88))
                .setCuts(Set.of(cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor15 = new Flavor()
                .setFlavor(FlavorEnum.CHOCOLATE_PEANUT_BUTTER)
                .setPictures(Set.of(proteinPic88))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);

        Flavor barFlavor1 = new Flavor()
                .setFlavor(FlavorEnum.DOUBLE_RICH_CHOCOLATE)
                .setPictures(Set.of(barPicture))
                .setCuts(Set.of(cut40))
                .setAvailable(true);
        Flavor barFlavor2 = new Flavor()
                .setFlavor(FlavorEnum.BISCUITS_WITH_CREAM)
                .setPictures(Set.of(barPicture2, barPicturePack))
                .setCuts(Set.of(cut40, cutBox))
                .setAvailable(true);
        Flavor barFlavor3 = new Flavor()
                .setFlavor(FlavorEnum.COOKIES_CREAM)
                .setPictures(Set.of(barPictureCoffee))
                .setCuts(Set.of(cutBox))
                .setAvailable(true);

        flavor1 = this.flavorRepository.save(flavor1);
        flavor2 = this.flavorRepository.save(flavor2);
        flavor3 = this.flavorRepository.save(flavor3);
        flavor4 = this.flavorRepository.save(flavor4);
        flavor5 = this.flavorRepository.save(flavor5);
        flavor6 = this.flavorRepository.save(flavor6);
        flavor7 = this.flavorRepository.save(flavor7);
        flavor8 = this.flavorRepository.save(flavor8);
        flavor9 = this.flavorRepository.save(flavor9);
        flavor10 = this.flavorRepository.save(flavor10);
        flavor11 = this.flavorRepository.save(flavor11);

        flavor12 = this.flavorRepository.save(flavor12);
        flavor13 = this.flavorRepository.save(flavor13);
        flavor14 = this.flavorRepository.save(flavor14);
        flavor15 = this.flavorRepository.save(flavor15);

        barFlavor1 = this.flavorRepository.save(barFlavor1);
        barFlavor2 = this.flavorRepository.save(barFlavor2);
        barFlavor3 = this.flavorRepository.save(barFlavor3);

        SpecialFeature glutenFree = new SpecialFeature()
                .setFeature(SpecialFeaturesEnum.GLUTEN_FREE);
        SpecialFeature vegetarian = new SpecialFeature()
                .setFeature(SpecialFeaturesEnum.VEGETARIAN);
        SpecialFeature vegan = new SpecialFeature()
                .setFeature(SpecialFeaturesEnum.VEGAN);

        glutenFree = this.specialFeatureRepository.save(glutenFree);
        vegetarian = this.specialFeatureRepository.save(vegetarian);
        vegan = this.specialFeatureRepository.save(vegan);


        Category categorySupp = new Category()
                .setCategory(ProductCategoriesEnum.SUPPLEMENT)
                .setDescription("You can choose from our extremely wide specter of supplements that are tested " +
                        "and widely chosen amongst the gym society");

        Category categoryProtein = new Category()
                .setCategory(ProductCategoriesEnum.PROTEIN)
                .setDescription("The best way to improve the `quality of your training and gain muscle faster.");

        Category categoryBar = new Category()
                .setCategory(ProductCategoriesEnum.BAR)
                .setDescription("You feel hungry but don't want to eat too much. We have the perfect healthy snack!");

        categorySupp = this.categoryRepository.save(categorySupp);
        categoryProtein = this.categoryRepository.save(categoryProtein);
        categoryBar = this.categoryRepository.save(categoryBar);


        Supplement protein = new Supplement()
                .setSpecialFeatures(Set.of(vegetarian, glutenFree))
                .setFlavor(Set.of(flavor1, flavor2, flavor3, flavor4, flavor5,
                        flavor6, flavor7, flavor8, flavor9, flavor10, flavor11));
        protein.setName("PowerStorm Whey Protein");
        protein.setDescription("With our number one selling product you can enjoy more gains " +
                "in the gym while having a doze of your protein shake with your favourite flavor");
        protein.setCategory(Set.of(categoryProtein, categorySupp));
        protein.setRating(4.94);
        protein.setSlogan("The GymRats' choice");

        Supplement protein88 = new Supplement()
                .setSpecialFeatures(Set.of(glutenFree))
                .setFlavor(Set.of(flavor12, flavor13, flavor14, flavor15));

        protein88.setName("PowerStorm Whey Protein 88");
        protein88.setDescription("One of the company's bestsellers. Unmatched experience and results");
        protein88.setCategory(Set.of(categoryProtein, categorySupp));
        protein88.setRating(4.78);
        protein88.setSlogan("The GymRats' choice");

        Supplement barChoco = new Supplement()
                .setSpecialFeatures(Set.of(glutenFree, vegan))
                .setFlavor(Set.of(barFlavor1));

        barChoco.setName("PowerStorm Choco Protein Bar");
        barChoco.setDescription("The perfect choice for the moments when you want to have something sweet but also want to be healthy");
        barChoco.setCategory(Set.of(categoryBar, categorySupp));
        barChoco.setRating(4.86);
        barChoco.setSlogan("A healthy breakfast");

        Supplement barBiscuit = new Supplement()
                .setSpecialFeatures(Set.of(glutenFree, vegan))
                .setFlavor(Set.of(barFlavor2, barFlavor3));

        barBiscuit.setName("PowerStorm 3 Layers Protein Bar");
        barBiscuit.setDescription("3 layers of pleasure for your cutting gym diet");
        barBiscuit.setCategory(Set.of(categoryBar, categorySupp));
        barBiscuit.setRating(4.93);
        barBiscuit.setSlogan("A healthy breakfast");

        this.supplementRepository.save(protein);
        this.supplementRepository.save(protein88);

        this.supplementRepository.save(barChoco);
        this.supplementRepository.save(barBiscuit);


    }
}
