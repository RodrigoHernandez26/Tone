import { CommandInteraction, Message } from "discord.js";
import { Command } from "./command";
import CommandMusic from "./music_utils/commandMusic";

export default class Pause implements Command {

    name: string = 'pause'
    description: string = 'Pause the song'
    options: Array<string> = []
    
    commandMusic: CommandMusic

    constructor(commandMusic: CommandMusic){
        this.commandMusic = commandMusic
    }

    execute(message: Message | CommandInteraction)     {
        if (!this.commandMusic.getVoiceConnection){
            message.reply('I\'m not in a voice channel')
            return
        }

        this.commandMusic.audioPlayer.pause()
        message.reply('Paused')
    }
}