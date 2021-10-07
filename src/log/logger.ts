import axios, { AxiosRequestConfig } from "axios";
import { environment } from "../environments/environment";

export default class Logger {

    private logging: boolean = environment.log
    private URL: string = 'https://log-api.newrelic.com/log/v1'

    async send(logType: string, message: string): Promise<void>{
        if (!this.logging) return

        let payload = {
            timestamp: new Date().getTime(),
            message: message,
            logtype: logType
        }

        let options: AxiosRequestConfig = {
            params: {
                "Api-Key": environment.newRelicKey
            }
        }

        await axios.post(this.URL, payload, options)
    }
}