package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.ui.Picture;
import gui.GameGUI;

/**
 * test
 * @author Michael Nilsson
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        /*Picture pic = new Picture("HUD Picture");
        pic.setImage(assetManager, "Textures/ColonialMarines_4.png", true);
        pic.setWidth(32);
        pic.setHeight(32);
        pic.setPosition(settings.getWidth()/4, settings.getHeight()/4);
        guiNode.attachChild(pic);
        */
        GameGUI gui_display = new GameGUI (assetManager,
                                           inputManager,
                                           audioRenderer,
                                           guiViewPort);
        
        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
        
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);

        rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
