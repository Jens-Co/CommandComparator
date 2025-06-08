# CommandComparator

**CommandComparator** (short: **CC**) is a lightweight Minecraft plugin that allows you to execute different commands depending on whether the player is using Java Edition or Bedrock Edition. Ideal for cross-play servers using **Geyser** or **Floodgate**.

---

Example usage:

/cc say Hello Java || tellraw @a {"text":"Hello Bedrock"}

- Java players will execute: `say Hello Java`
- Bedrock players will execute: `tellraw @a {"text":"Hello Bedrock"}`

---

## ⚙️ Requirements

- [Geyser](https://geysermc.org/) or [Floodgate](https://github.com/GeyserMC/Floodgate)

---

## 🚀 Installation

1. Download the latest plugin JAR from the [Modrinth](https://modrinth.com/plugin/commandcomperator) tab (or build it yourself).
2. Place `CommandComparator.jar` in your server's `plugins/` directory.
3. Restart your server.
4. Done! The plugin will auto-detect Geyser or Floodgate.

---

