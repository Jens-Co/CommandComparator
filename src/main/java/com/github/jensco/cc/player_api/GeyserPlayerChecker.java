package com.github.jensco.cc.player_api;

import com.github.jensco.cc.PlayerCheckerInterface;
import org.geysermc.api.Geyser;

import java.util.UUID;

public class GeyserPlayerChecker implements PlayerCheckerInterface {

    @Override
    public boolean isBedrock(UUID uuid) {
        return Geyser.api().isBedrockPlayer(uuid);
    }
}
