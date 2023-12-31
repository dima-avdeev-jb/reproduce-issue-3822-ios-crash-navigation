import UIKit
import SwiftUI
import shared

struct ContentView: View {
    @State private var navigation = NavigationPath()

        var body: some View {
            NavigationStack(path: $navigation) {
                CoffeeSelectorsMobileRepresentable2(
                    onComposeClick: {
                        navigation.append(0)
                    }
                )
                .navigationDestination(for: Int.self) { destination in
                    Text("Press back to reproduce bug")
                }
                .ignoresSafeArea(.all)
            }
        }
}

public struct CoffeeSelectorsMobileRepresentable2: UIViewControllerRepresentable {
    let onComposeClick: () -> Void

    public func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.MainViewController(onComposeClick: onComposeClick)
    }

    public func updateUIViewController(_ uiViewController: UIViewController, context: Context) {

    }
}
