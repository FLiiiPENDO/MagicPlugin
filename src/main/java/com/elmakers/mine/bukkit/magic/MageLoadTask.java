package com.elmakers.mine.bukkit.magic;

import com.elmakers.mine.bukkit.api.data.MageData;

public class MageLoadTask implements Runnable {
    private final Mage mage;
    private final MageData data;

    public MageLoadTask(Mage mage, MageData data) {
        this.mage = mage;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            mage.onLoad(data);
            mage.setLoading(false);
        } catch (Exception ex) {
            mage.getController().getLogger().warning("Failed to load mage data for player " + mage.getName());
            mage.setLoading(true);
        }
    }
}