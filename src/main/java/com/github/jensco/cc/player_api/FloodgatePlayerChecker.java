package com.github.jensco.cc.player_api;

import com.github.jensco.cc.PlayerCheckerInterface;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.UUID;

public class FloodgatePlayerChecker implements PlayerCheckerInterface {

    @Override
    public boolean isBedrock(UUID uuid) {
        return FloodgateApi.getInstance().isFloodgatePlayer(uuid);
    }
}
