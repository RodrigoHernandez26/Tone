import {Command} from "./command";
import {CommandInteraction, Message} from "discord.js";
import MusicCommand from "./musicCommand";
import SucessEmbed from "../embeds/sucessEmbed";
import { CommandPropertiesInterface } from "../interfaces/CommandProperties.interface";

export default class Join extends MusicCommand implements Command{

    static properties: CommandPropertiesInterface = {
        name: 'join',
        description: 'join a voice channel',
        aliases: ['join', 'j']
    }

    execute(message: Message | CommandInteraction): void {
        this.musicController.join(message)
        message.reply({embeds: [SucessEmbed.create("What's Up?").build()]})
    }



}
