Public Class Form1

    <System.Runtime.InteropServices.DllImport("user32")> Private Shared Function GetAsyncKeyState(ByVal vKey As Integer) As Integer
    End Function

    Private Sub btnStart_Click(sender As Object, e As EventArgs) Handles btnStart.Click

        TimerReq.Enabled = True
        TimerReq.Interval = "500"
        TimerReq.Start()

    End Sub

    Private Sub btnStop_Click(sender As Object, e As EventArgs) Handles btnStop.Click

        TimerReq.Stop()
        TimerReq.Enabled = False

    End Sub

    Private Sub TimerReq_Tick(sender As Object, e As EventArgs) Handles TimerReq.Tick

        ' Get code
        Dim GetClient As New System.Net.WebClient
        Dim result As String = GetClient.DownloadString("http://13.232.144.194/ppt/getcode.php")


        If result = "1" Then

            ' 1 mean next.
            GetClient.DownloadString("http://13.232.144.194/ppt/changecode.php?code=2")

            SendKeys.Send("{ENTER}")


        End If

        If result = "0" Then

            ' 0 mean prev.
            GetClient.DownloadString("http://13.232.144.194/ppt/changecode.php?code=2")

            SendKeys.Send("{LEFT}")

        End If



    End Sub
End Class
