/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jme3.asset.AssetManager;
import com.jme3.texture.Texture;

/**
 *
 * @author mnn
 */
public class Battlefield {
    private static BattlefieldGridType[] _grid_types = null;
    
    public Battlefield (AssetManager asset_manager) {
        if (_grid_types == null) {
            //create all the terrain types
            _grid_types = new BattlefieldGridType[4];

            _grid_types[0] = new BattlefieldGridType(asset_manager.loadTexture("Textures/grass.png"),   BattlefieldGridType.GRID_GRASS);
            _grid_types[1] = new BattlefieldGridType(asset_manager.loadTexture("Textures/tree.png"),    BattlefieldGridType.GRID_TREE);
            _grid_types[2] = new BattlefieldGridType(asset_manager.loadTexture("Textures/rock.png"),    BattlefieldGridType.GRID_ROCK);
            _grid_types[3] = new BattlefieldGridType(asset_manager.loadTexture("Textures/water.png"),   BattlefieldGridType.GRID_WATER);
        }
    }
}
