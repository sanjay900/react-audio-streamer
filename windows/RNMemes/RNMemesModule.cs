using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Memes.RNMemes
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNMemesModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNMemesModule"/>.
        /// </summary>
        internal RNMemesModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNMemes";
            }
        }
    }
}
