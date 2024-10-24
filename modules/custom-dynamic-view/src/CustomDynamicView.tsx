import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { CustomDynamicViewProps } from './CustomDynamicView.types';

const NativeView: React.ComponentType<CustomDynamicViewProps> =
  requireNativeViewManager('CustomDynamicView');

export default React.forwardRef((props: CustomDynamicViewProps, ref) => {
  return <NativeView ref={ref} {...props} />
})
