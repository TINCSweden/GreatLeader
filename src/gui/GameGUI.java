/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.input.InputManager;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.ImageRenderer;
import de.lessvoid.nifty.render.NiftyImage;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

@SuppressWarnings("LeakingThisInConstructor")

/**
 *
 * @author mnn
 */
public class GameGUI extends NiftyJmeDisplay implements ScreenController {
    //private Node gui_node;
    
    private Nifty _nifty;
    
    public GameGUI (AssetManager assetManager, 
                    InputManager inputManager,
                    AudioRenderer audioRenderer,
                    ViewPort vp){
        super(assetManager, inputManager, audioRenderer, vp);
        
        _nifty = getNifty();
        _nifty.fromXml("Interface/Nifty/HelloJME.xml", "start", this);
        
        
        
        NiftyImage img = _nifty.getRenderEngine().createImage("Textures/ColonialMarines_4.png", false);
        
        
        // find old image
        Element niftyElement = _nifty.getCurrentScreen().findElementByName("battlefield");
        // swap old with new image
        niftyElement.getRenderer(ImageRenderer.class).setImage(img);
        
        
        inputManager.setCursorVisible(true);
        vp.addProcessor(this);
    }
    
    public void create_battle_window () {
        
    }

    public void bind(Nifty nifty, Screen screen) {
        System.out.println("bind( " + screen.getScreenId() + ")");
    }

    public void onStartScreen() {
        System.out.println("onStartScreen");
    }

    public void onEndScreen() {
        System.out.println("onEndScreen");
    }
}
