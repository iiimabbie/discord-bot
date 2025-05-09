package per.iiimabbie.discordbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import per.iiimabbie.discordbot.core.BotCore;

/**
 * 機器人主類，入口點
 */
public class BotMain {

  private static final Logger logger = LoggerFactory.getLogger(BotMain.class);

  public static void main(String[] args) {
    try {
      // 初始化並啟動機器人
      BotCore botCore = new BotCore();
      logger.info("Bot，啟動！");

      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        logger.info("正在關閉Bot...");
        botCore.shutdown();
      }));

    } catch (Exception e) {
      logger.error("Bot 啟動失敗: {}", e.getMessage(), e);
    }
  }
}