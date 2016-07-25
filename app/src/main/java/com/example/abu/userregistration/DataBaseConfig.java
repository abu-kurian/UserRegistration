package com.example.abu.userregistration;

/**
 * Created by abu on 15/7/16.
 */
public class DataBaseConfig {

    private String _USN;
    private byte[] _isoTemplate;

    public DataBaseConfig(String USN, byte[] isoTemplate)
    {
        this._isoTemplate=isoTemplate;
        this._USN=USN;
    }

    public void set_USN(String _USN) {
        this._USN = _USN;
    }

    public void set_isoTemplate(byte[] _isoTemplate) {
        this._isoTemplate = _isoTemplate;
    }

    public String get_USN() {
        return _USN;
    }

    public byte[] get_isoTemplate() {
        return _isoTemplate;
    }
}
