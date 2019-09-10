package com.willyranz.prambanan_virtual_guide;

/**
 * Created by Acer V5-132 on 4/5/2016.
 */
public interface ArchitectViewHolderInterface {

    /**
     * path to the architect-file (AR-Experience HTML) to launch
     *
     * @return
     */
    public String getARchitectWorldPath();


    /**
     * @return layout id of your layout.xml that holds an ARchitect View, e.g. R.layout.camview
     */
    public int getContentViewId();

    /**
     * @return Wikitude SDK license key, checkout www.wikitude.com for details
     */
    public String getWikitudeSDKLicenseKey();

    /**
     * @return layout-id of architectView, e.g. R.id.architectView
     */
    public int getArchitectViewId();

}