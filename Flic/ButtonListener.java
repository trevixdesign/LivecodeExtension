package com.livecode.library.flic;


import io.flic.flic2libandroid.*;

public class ButtonListener extends Flic2ButtonListener
{
    public interface ButtonListenerListener 
    {
        void onConnect(Flic2Button button);
        void onReady(Flic2Button button, long timestamp);
        void onDisconnect(Flic2Button button);
        void onUnpaired(Flic2Button button);
        void onFailure(Flic2Button button, int errorCode, int subCode);
        void onNameUpdated(Flic2Button button, String newName);
        void onButtonUpOrDown(Flic2Button button, boolean wasQueued, boolean lastQueued, long timestamp, boolean isUp, boolean isDown);
        void onButtonSingleOrDoubleClickOrHold(Flic2Button button, boolean wasQueued, boolean lastQueued, long timestamp, boolean isSingleClick, boolean isDoubleClick, boolean isHold);
    }

    private ButtonListenerListener m_listener = null;
    public void setListener(ButtonListenerListener p_listener)
    {
        m_listener = p_listener;
    }

    @Override
    public void onConnect(Flic2Button button)
    {
        if (m_listener != null)
        {
            m_listener.onConnect(button);
        }
    }

    @Override
    public void onReady(Flic2Button button, long timestamp)
    {
        if (m_listener != null)
        {
            m_listener.onReady(button, timestamp);
        }
    }

    @Override
    public void onDisconnect(Flic2Button button)
    {
        if (m_listener != null)
        {
            m_listener.onDisconnect(button);
        }
    }

    @Override
    public void onUnpaired(Flic2Button button)
    {
        if (m_listener != null)
        {
            m_listener.onUnpaired(button);
        }
    }

    @Override
    public void onFailure(Flic2Button button, int errorCode, int subCode)
    {
        if (m_listener != null)
        {
            m_listener.onFailure(button, errorCode, subCode);
        }
    }

    @Override
    public void onNameUpdated(Flic2Button button, String newName)
    {
        if (m_listener != null)
        {
            m_listener.onNameUpdated(button, newName);
        }
    }

    @Override
    public void onButtonUpOrDown(Flic2Button button, boolean wasQueued, boolean lastQueued, long timestamp, boolean isUp, boolean isDown)
    {
        if (m_listener != null)
        {
            m_listener.onButtonUpOrDown(button, wasQueued, lastQueued, timestamp, isUp, isDown);
        }
    }

    @Override
    public void onButtonSingleOrDoubleClickOrHold(Flic2Button button, boolean wasQueued, boolean lastQueued, long timestamp, boolean isSingleClick, boolean isDoubleClick, boolean isHold)
    {
        if (m_listener != null)
        {
            m_listener.onButtonSingleOrDoubleClickOrHold(button, wasQueued, lastQueued, timestamp, isSingleClick, isDoubleClick, isHold);
        }
    }

}
