export default class Utils{


    static formatString(text: string): string{
        const STRING_SIZE = 50

        let strLen = text.length;
        if (strLen > STRING_SIZE){
            return text.substr(0, STRING_SIZE-1) + "…";
        }
        return text.padEnd(STRING_SIZE," ");
    }

    static parseSecondsToISO(lenghtSeconds: number): string{
        let seconds = lenghtSeconds % 60;
        let minutes = seconds/60>>0%60;
        let hours = seconds/3600>>0;
        let response = "";

        if(hours > 0)
            response += `${hours}:`
        response += `${minutes}:${seconds}`
        return response

    }

    static parseISOToSeconds(ISO : string): number{
        let ISOArr = ISO.split(":");
        let multi = 1;
        let total = 0;
        for (const isoArrKey in ISOArr) {
            total += parseInt(isoArrKey)*multi;
            multi *= 60;
        }
        return total;
    }
}