package design.BuilderModel;

import design.BuilderModel.ceiling.LevelOneCeiling;
import design.BuilderModel.ceiling.LevelTwoCeiling;
import design.BuilderModel.coat.DuluxCoat;
import design.BuilderModel.coat.LiBangCoat;
import design.BuilderModel.floor.ShengXiangFloor;
import design.BuilderModel.tile.DongPengTile;
import design.BuilderModel.tile.MarcoPoloTile;

public class Builder {
    public IMenu levelOne(Double area){
        return  new DecorationPackageMenu(area,"豪华欧式")
                .appendCeiling(new LevelOneCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }
    public IMenu levelTwo(Double area){
        return  new DecorationPackageMenu(area,"轻奢田园")
                .appendTile(new MarcoPoloTile())
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new LiBangCoat());
    }
    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area,"现代简约")
                .appendCeiling(new LevelOneCeiling())
                .appendCoat(new LiBangCoat())
                .appendTile(new DongPengTile());
    }
}
